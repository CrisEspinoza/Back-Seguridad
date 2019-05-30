package cl.sportapp.evaluation.config.configController;

import cl.sportapp.evaluation.config.Pay.Payload;
import cl.sportapp.evaluation.config.jwt.JwtProvider;
import cl.sportapp.evaluation.config.message.request.CambiarContraseña;
import cl.sportapp.evaluation.config.message.request.ResetearContraseña;
import cl.sportapp.evaluation.dao.RoleDao;
import cl.sportapp.evaluation.dao.UsuarioDao;
import cl.sportapp.evaluation.entitie.Role;
import cl.sportapp.evaluation.entitie.RoleName;
import cl.sportapp.evaluation.entitie.Usuario;
import cl.sportapp.evaluation.config.message.request.LoginForm;
import cl.sportapp.evaluation.config.message.request.SignUpForm;
import cl.sportapp.evaluation.config.message.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioDao userRepository;

    @Autowired
    RoleDao roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private final UsuarioDao usuarioDao;

    public AuthRestAPIs(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Usuario user = new Usuario(signUpRequest.getNombres(), signUpRequest.getApellidos(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()), signUpRequest.getCelular());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {

            switch(role) {


                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;

                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }

    @Transactional
    @PostMapping("/changePassword")
    public ResponseEntity<Payload<?>> changeUserPassword(@RequestBody CambiarContraseña request) {

        // id Usuario
        Long userId = request.getUserId();

        // contraseña antigua
        String oldPassword = request.getOldPassword();

        // contraseña nueva
        String newPassword = request.getNewPassword();

        System.out.println(userId);
        System.out.println(oldPassword);
        System.out.println(newPassword);
        // System.out.println(userId+' '+ oldPassword+ ' ' + newPassword);
        Usuario usuario;

        try {
            usuario = em.find(Usuario.class, userId);
        } catch (DataAccessException ex) {
            return ResponseEntity.badRequest().body(Payload.of("Error al cambiar la password"));
        }

        String currentPassword = usuario.getPassword();

        if (BCrypt.checkpw(oldPassword, currentPassword)) {
            try {
                usuario.setPassword(newPassword);
                userRepository.save(usuario);
                return ResponseEntity.ok(Payload.of(usuario));
            } catch (DataAccessException ex) {
                return ResponseEntity.badRequest().body(Payload.of("Error al cambiar la password"));
            }
        } else {
            return ResponseEntity.badRequest().body(Payload.of("La contraseña Ingresada no es correcta"));
        }
    }

    @Transactional
    @PostMapping("/resetPassword")
    public ResponseEntity<Payload<?>> resetPasswordRequest(@RequestBody ResetearContraseña request) {

        // id Usuario
        Long userId = request.getUserId();

        // contraseña nueva
        String newPassword = request.getNewPassword();

        Usuario usuario;

        try {
            usuario = em.find(Usuario.class, userId);
        } catch (DataAccessException ex) {
            return ResponseEntity.badRequest().body(Payload.of("Error al cambiar la password"));
        }

        try {
            usuario.setPassword(encoder.encode(newPassword));
            userRepository.save(usuario);
            return ResponseEntity.ok(Payload.of(usuario));
        } catch (DataAccessException ex) {
            return ResponseEntity.badRequest().body(Payload.of("Error al cambiar la password"));
        }
    }

    @Transactional
    @GetMapping("/exit")
    public ResponseEntity<Payload<?>> logout(HttpServletRequest request) {

        //Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();

        /*em.persist(Syslog.syslogBuilder(request)
                .setType(Syslog.Type.LOGOUT)
                .setState(Syslog.State.SUCCESS)
                .setSummary("Logout from " + usuario.getCuentaAcceso())
                .setUsuario(usuario)
                .build());
        */

        return ResponseEntity.ok().body(Payload.of("logout ok"));
    }

    @PostMapping("/{id}/signUpForm")
    public ResponseEntity<Payload<?>> updateUser(@PathVariable("id") Long id,@Valid @RequestBody SignUpForm signUpForm) {

        Usuario usuario = usuarioDao.findById(id);

        // Por el momento tengo esos atributos que modificar, la contraseña esta en un servicio aparte.
        usuario.setNombres(signUpForm.getNombres());
        usuario.setApellidos(signUpForm.getApellidos());
        usuario.setCelular(signUpForm.getCelular());

        usuarioDao.save(usuario);

        return ResponseEntity.ok().body(Payload.of("Cambios realizados"));
    }


}

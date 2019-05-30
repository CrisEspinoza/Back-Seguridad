package cl.sportapp.evaluation.config.service;

import cl.sportapp.evaluation.dao.UsuarioDao;
import cl.sportapp.evaluation.entitie.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioDao usuarioDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioDao.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + email)
                );

        return UserPrinciple.build(usuario);
    }
}
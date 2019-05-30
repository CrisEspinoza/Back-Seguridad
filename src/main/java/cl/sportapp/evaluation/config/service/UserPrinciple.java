package cl.sportapp.evaluation.config.service;

import cl.sportapp.evaluation.entitie.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nombres;

    private String apellidos;

    private String email;

    private String celular;

    private int estado;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long id, String name,
                         String username, String email, String password,
                         Collection<? extends GrantedAuthority> authorities , String celular) {
        this.id = id;
        this.nombres = name;
        this.apellidos = username;
        this.email = email;
        this.password = password;
        this.celular = celular;
        this.estado = 1;
        this.authorities = authorities;
    }

    public static UserPrinciple build(Usuario user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getNombres(),
                user.getApellidos(),
                user.getEmail(),
                user.getPassword(),
                authorities,
                user.getCelular()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.nombres = name;
    }

    public void setUsername(String username) {
        this.apellidos = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}

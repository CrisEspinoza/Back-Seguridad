package cl.sportapp.evaluation.config.message.request;

import lombok.Data;

import java.util.Set;

@Data
public class SignUpForm {

    private String nombres;

    private String apellidos;

    private String email;

    private Set<String> role;

    private String password;

    private String celular;

    private int estado;
}

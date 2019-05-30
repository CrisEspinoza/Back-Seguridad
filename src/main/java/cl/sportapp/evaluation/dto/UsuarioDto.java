package cl.sportapp.evaluation.dto;

import cl.sportapp.evaluation.entitie.Role;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {

    private Integer id;

    private String username;

    private String email;

    //List<Role> roles;

}

package cl.sportapp.evaluation.config.message.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CambiarContraseña {

    private Long userId;
    private String oldPassword;
    private String newPassword;
}

package cl.sportapp.evaluation.config.message.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResetearContraseña {

    private Long userId;
    private String newPassword;

}

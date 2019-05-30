package cl.sportapp.evaluation.dto;

import cl.sportapp.evaluation.entitie.Paciente;
import cl.sportapp.evaluation.entitie.SubtipoMedicion;
import cl.sportapp.evaluation.entitie.TipoEvaluacion;
import lombok.Data;

@Data
public class EvaluacionDto {

    private Long id;

    private int medicion1;

    private int medicion2;

    private int medicion3;

    private int medicion4;

    private int medicion5;

    private int mediana;

    private int scoreZ;

    private SubtipoMedicion subtipoMedicion;

    private TipoEvaluacion tipoEvaluacion;

    private Paciente paciente;
}

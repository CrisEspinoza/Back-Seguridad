package cl.sportapp.evaluation.dto;

import cl.sportapp.evaluation.entitie.Evaluacion;
import cl.sportapp.evaluation.entitie.TipoMedicion;
import lombok.Data;

import java.util.List;

@Data
public class SubtipoMedicionDto {

    private Long id;

    private String nombre;

    private boolean estado;

    private TipoMedicion tipoMedicion;

    private List<Evaluacion> evaluacions;
}

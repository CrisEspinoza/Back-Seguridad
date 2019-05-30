package cl.sportapp.evaluation.entitie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Data
@Entity(name = "tipo_evaluacion")
public class TipoEvaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_EVALUACION_SEQ")
    @SequenceGenerator(name = "TIPO_EVALUACION_SEQ", sequenceName = "SEQ_TIPO_EVALUACION", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private String nombre;

    @OneToMany(mappedBy="tipoEvaluacion")
    @JsonIgnore
    private List<Evaluacion> evaluacions;

    @OneToMany(mappedBy="tipoEvaluacion")
    @JsonIgnore
    private List<EvaluacionTest> evaluacionTests ;

}

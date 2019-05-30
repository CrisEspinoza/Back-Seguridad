package cl.sportapp.evaluation.entitie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Data
@Entity(name = "evaluacion")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVALUACION_SEQ")
    @SequenceGenerator(name = "EVALUACION_SEQ", sequenceName = "SEQ_EVALUACION", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private int medicion1;

    @Column
    private int medicion2;

    @Column
    private int medicion3;

    @Column
    private int medicion4;

    @Column
    private int medicion5;

    @Column
    private int mediana;

    @Column(name = "score_z")
    private int scoreZ;

    @ManyToOne
    @JoinColumn(name="subtipo_medicion")
    @JsonIgnore
    private SubtipoMedicion subtipoMedicion;

    @ManyToOne
    @JoinColumn(name="tipo_evaluacion")
    @JsonIgnore
    private TipoEvaluacion tipoEvaluacion;

    @ManyToOne
    @JoinColumn(name="paciente")
    @JsonIgnore
    private Paciente paciente;

}

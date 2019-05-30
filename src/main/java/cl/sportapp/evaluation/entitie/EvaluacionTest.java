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
import java.time.LocalDate;

@Data
@Entity(name = "evaluacion_test")
public class EvaluacionTest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVALUACIONTEST_SEQ")
    @SequenceGenerator(name = "EVALUACIONTEST_SEQ", sequenceName = "SEQ_EVALUACIONTEST", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "valor_test")
    private String valorTest;

    @Column(name = "fecha_evaluacion")
    private LocalDate fechaEvaluacion;

    @Column(name = "profesional_evaluador")
    private String profesionalEvaluador;

    @ManyToOne
    @JoinColumn(name="paciente")
    @JsonIgnore
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="tipo_evaluacion")
    @JsonIgnore
    private TipoEvaluacion tipoEvaluacion;

    @ManyToOne
    @JoinColumn(name="test")
    @JsonIgnore
    private Test test;

}

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
@Entity(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SEQ")
    @SequenceGenerator(name = "TEST_SEQ", sequenceName = "SEQ_TEST", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private String nombre;

    @Column
    private String formula;

    @OneToMany(mappedBy="test")
    @JsonIgnore
    private List<EvaluacionTest> evaluacionTests;
}

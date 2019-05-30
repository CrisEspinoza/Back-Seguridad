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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Data
@Entity(name = "subtipo_medicion")
public class SubtipoMedicion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBTIPO_MEDICION_SEQ")
    @SequenceGenerator(name = "SUBTIPO_MEDICION_SEQ", sequenceName = "SEQ_SUBTIPO_MEDICION", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private String nombre;

    @Column
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="tipo_medicion")
    @JsonIgnore
    private TipoMedicion tipoMedicion;

    @OneToMany(mappedBy="subtipoMedicion")
    @JsonIgnore
    private List<Evaluacion>  evaluacions;
}

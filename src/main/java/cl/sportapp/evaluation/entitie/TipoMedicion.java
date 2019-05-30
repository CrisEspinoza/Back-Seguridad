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
@Entity(name = "tipo_medicion")
public class TipoMedicion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_MEDICION_SEQ")
    @SequenceGenerator(name = "TIPO_MEDICION_SEQ", sequenceName = "SEQ_TIPO_MEDICION", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private String nombre;

    @Column
    private boolean estado;

    @OneToMany(mappedBy="tipoMedicion")
    @JsonIgnore
    private List<SubtipoMedicion> subtipoMedicions;
}

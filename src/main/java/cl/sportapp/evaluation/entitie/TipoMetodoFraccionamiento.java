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
@Entity(name = "tipo_metodo_fraccionamiento")
public class TipoMetodoFraccionamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_METODO_FRACCIONAMIENTO_SEQ")
    @SequenceGenerator(name = "TIPO_METODO_FRACCIONAMIENTO_SEQ", sequenceName = "SEQ_TIPO_METODO_FRACCIONAMIENTO", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private String nombre;

    @Column
    private boolean estado;

    @OneToMany(mappedBy="tipoMetodoFraccionamiento")
    @JsonIgnore
    private List<DetalleMetodoFraccionamiento> detalleMetodoFraccionamientos;
}

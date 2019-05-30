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
@Entity(name = "detalle_metodo_fraccionamiento")
public class DetalleMetodoFraccionamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DETALLE_METODO_FRACCIONAMIENTO_SEQ")
    @SequenceGenerator(name = "DETALLE_METODO_FRACCIONAMIENTO_SEQ", sequenceName = "SEQ_DETALLE_METODO_FRACCIONAMIENTO", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private int kilogramo;

    @Column
    private int porcentaje;

    @Column(name = "score_z")
    private int scoreZ;

    @Column(name = "dif_peso")
    private int difPeso;

    @ManyToOne
    @JoinColumn(name="tipo_metodo_fraccionamiento")
    @JsonIgnore
    private TipoMetodoFraccionamiento tipoMetodoFraccionamiento;

    @ManyToOne
    @JoinColumn(name="paciente")
    @JsonIgnore
    private Paciente paciente;
}

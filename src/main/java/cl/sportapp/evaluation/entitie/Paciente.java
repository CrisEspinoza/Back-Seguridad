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
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PACIENTE_SEQ")
    @SequenceGenerator(name = "PACIENTE_SEQ", sequenceName = "SEQ_PACIENTE", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column
    private String email;

    @Column
    private String celular;

    @Column(name = "fecha_evaluacion")
    private LocalDate fechaEvaluacion;

    @Column
    private String actividad;

    @Column
    private String sexo;

    @Column
    private int edad;

    @Column
    private int peso;

    @Column
    private int talla;

    @Column(name = "talla_sentado")
    private int tallaSentado;

    @Column
    private int envergadura;

    @Column(name = "media_talla_sentado")
    private int mediaTallaSentado;

    @Column(name = "altura_cajon")
    private int alturaCajon;

    @Column(name = "nivel_actividad_fisica")
    private String nivelActividadFisica;

    @Column(name = "gasto_kcal")
    private int gastoKcal;

    @OneToMany(mappedBy="paciente")
    @JsonIgnore
    private List<Evaluacion> evaluacions;

    @OneToMany(mappedBy="paciente")
    @JsonIgnore
    private List<DetalleMetodoFraccionamiento> detalleMetodoFraccionamientos;

    @OneToMany(mappedBy="paciente")
    @JsonIgnore
    private List<EvaluacionTest> evaluacionTests;

}

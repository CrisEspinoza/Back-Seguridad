package cl.sportapp.evaluation.dto;

import cl.sportapp.evaluation.entitie.DetalleMetodoFraccionamiento;
import cl.sportapp.evaluation.entitie.Evaluacion;
import cl.sportapp.evaluation.entitie.EvaluacionTest;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PacienteDto {

    private Long id;

    private String nombre;

    private LocalDate fechaNacimiento;

    private String email;

    private String celular;

    private LocalDate fechaEvaluacion;

    private String actividad;

    private String sexo;

    private int edad;

    private int peso;

    private int talla;

    private int tallaSentado;

    private int envergadura;

    private int mediaTallaSentado;

    private int alturaCajon;

    private String nivelActividadFisica;

    private int gastoKcal;

    private List<Evaluacion> evaluacions;

    private List<DetalleMetodoFraccionamiento> detalleMetodoFraccionamientos;

    private List<EvaluacionTest> evaluacionTests;
}

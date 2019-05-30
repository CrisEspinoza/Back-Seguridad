package cl.sportapp.evaluation.mapper;

import cl.sportapp.evaluation.dto.PacienteDto;
import cl.sportapp.evaluation.entitie.Paciente;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public PacienteDto pacienteToPacienteDto (Paciente paciente){

        PacienteDto pacienteDto = new PacienteDto();

        pacienteDto.setId(paciente.getId());
        pacienteDto.setNombre(paciente.getNombre());
        pacienteDto.setFechaNacimiento(paciente.getFechaNacimiento());
        pacienteDto.setEmail(paciente.getEmail());
        pacienteDto.setCelular(paciente.getCelular());
        pacienteDto.setFechaEvaluacion(paciente.getFechaEvaluacion());
        pacienteDto.setActividad(paciente.getActividad());
        pacienteDto.setSexo(paciente.getSexo());
        pacienteDto.setEdad(paciente.getEdad());
        pacienteDto.setPeso(paciente.getPeso());
        pacienteDto.setTalla(paciente.getTalla());
        pacienteDto.setTallaSentado(paciente.getTallaSentado());
        pacienteDto.setEnvergadura(paciente.getEnvergadura());
        pacienteDto.setMediaTallaSentado(paciente.getMediaTallaSentado());
        pacienteDto.setAlturaCajon(paciente.getAlturaCajon());
        pacienteDto.setNivelActividadFisica(paciente.getNivelActividadFisica());
        pacienteDto.setGastoKcal(paciente.getGastoKcal());
        pacienteDto.setEvaluacions(paciente.getEvaluacions());
        pacienteDto.setDetalleMetodoFraccionamientos(paciente.getDetalleMetodoFraccionamientos());
        pacienteDto.setEvaluacionTests(paciente.getEvaluacionTests());


        return pacienteDto;
    }

    public Paciente pacienteDtoToPaciente (PacienteDto pacienteDto){

        Paciente paciente = new Paciente();

        paciente.setId(pacienteDto.getId());
        paciente.setNombre(pacienteDto.getNombre());
        paciente.setFechaNacimiento(pacienteDto.getFechaNacimiento());
        paciente.setEmail(pacienteDto.getEmail());
        paciente.setCelular(pacienteDto.getCelular());
        paciente.setFechaEvaluacion(pacienteDto.getFechaEvaluacion());
        paciente.setActividad(pacienteDto.getActividad());
        paciente.setSexo(pacienteDto.getSexo());
        paciente.setEdad(pacienteDto.getEdad());
        paciente.setPeso(pacienteDto.getPeso());
        paciente.setTalla(pacienteDto.getTalla());
        paciente.setTallaSentado(pacienteDto.getTallaSentado());
        paciente.setEnvergadura(pacienteDto.getEnvergadura());
        paciente.setMediaTallaSentado(pacienteDto.getMediaTallaSentado());
        paciente.setAlturaCajon(pacienteDto.getAlturaCajon());
        paciente.setNivelActividadFisica(pacienteDto.getNivelActividadFisica());
        paciente.setGastoKcal(pacienteDto.getGastoKcal());
        paciente.setEvaluacions(pacienteDto.getEvaluacions());
        paciente.setDetalleMetodoFraccionamientos(pacienteDto.getDetalleMetodoFraccionamientos());
        paciente.setEvaluacionTests(pacienteDto.getEvaluacionTests());

        return paciente;
    }

}

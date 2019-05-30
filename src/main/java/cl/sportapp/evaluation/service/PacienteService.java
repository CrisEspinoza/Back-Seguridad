package cl.sportapp.evaluation.service;

import cl.sportapp.evaluation.dao.PacienteDao;
import cl.sportapp.evaluation.dto.PacienteDto;
import cl.sportapp.evaluation.entitie.Paciente;
import cl.sportapp.evaluation.mapper.PacienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteDao pacienteDao;

    @Autowired
    private PacienteMapper pacienteMapper;

    public Paciente newUser (PacienteDto pacienteDto) {

        Paciente paciente = pacienteMapper.pacienteDtoToPaciente(pacienteDto);
        pacienteDao.save(paciente);
        return paciente;
    }

    public Paciente findByUser (Long id){
        return pacienteDao.findById(id).get();
    }

    public Paciente updateUser(Long id , PacienteDto pacienteDto){

        Paciente paciente = pacienteDao.findById(id).get();

        paciente = pacienteMapper.pacienteDtoToPaciente(pacienteDto);

        return paciente;
    }
}

package cl.sportapp.evaluation.service;

import cl.sportapp.evaluation.dao.EvaluacionDao;
import cl.sportapp.evaluation.dao.PacienteDao;
import cl.sportapp.evaluation.dao.SubtipoMedicionDao;
import cl.sportapp.evaluation.dto.EvaluacionDto;
import cl.sportapp.evaluation.entitie.Evaluacion;
import cl.sportapp.evaluation.entitie.Paciente;
import cl.sportapp.evaluation.entitie.SubtipoMedicion;
import cl.sportapp.evaluation.mapper.EvaluacionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionDao evaluacionDao;

    @Autowired
    private EvaluacionMapper evaluacionMapper;

    @Autowired
    private PacienteDao pacienteDao;

    @Autowired
    private SubtipoMedicionDao subtipoMedicionDao;

    public ArrayList<EvaluacionDto> getAllEvaluation ()
    {
        ArrayList<Evaluacion> evaluacions = evaluacionDao.findAll();
        return evaluacionMapper.generateEvaluationDTOS(evaluacions);
    }

    public Evaluacion newEvaluation (Long idPaciente, Long idSubtipoMedicion, EvaluacionDto evaluacionDto) {

        Evaluacion evaluacion = evaluacionMapper.evaluacionDtoToEvaluacion(evaluacionDto);


        SubtipoMedicion subtipoMedicion = subtipoMedicionDao.findById(idSubtipoMedicion).get();
        Paciente paciente = pacienteDao.findById(idPaciente).get();
        evaluacion.setPaciente(paciente);
        evaluacion.setSubtipoMedicion(subtipoMedicion);

        evaluacionDao.save(evaluacion);

        return evaluacion;
    }

    public Evaluacion findByEvaluation (Long id){
        return evaluacionDao.findById(id).get();
    }

    public Evaluacion updateEvaluation(Long id , EvaluacionDto userDto){

        Evaluacion evaluacion = evaluacionDao.findById(id).get();

        evaluacion = evaluacionMapper.evaluacionDtoToEvaluacion(userDto);

        return evaluacion;
    }
}

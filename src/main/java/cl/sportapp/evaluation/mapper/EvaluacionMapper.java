package cl.sportapp.evaluation.mapper;

import cl.sportapp.evaluation.dto.EvaluacionDto;
import cl.sportapp.evaluation.entitie.Evaluacion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EvaluacionMapper {

    public Evaluacion evaluacionDtoToEvaluacion (EvaluacionDto evaluacionDto){

        Evaluacion evaluacion = new Evaluacion();

        evaluacion.setId(evaluacionDto.getId());
        evaluacion.setMedicion1(evaluacionDto.getMedicion1());
        evaluacion.setMedicion2(evaluacionDto.getMedicion2());
        evaluacion.setMedicion3(evaluacionDto.getMedicion3());
        evaluacion.setMedicion4(evaluacionDto.getMedicion4());
        evaluacion.setMedicion5(evaluacionDto.getMedicion5());
        evaluacion.setMediana(evaluacionDto.getMediana());
        evaluacion.setScoreZ(evaluacionDto.getScoreZ());
        evaluacion.setSubtipoMedicion(evaluacionDto.getSubtipoMedicion());
        evaluacion.setTipoEvaluacion(evaluacionDto.getTipoEvaluacion());
        evaluacion.setPaciente(evaluacionDto.getPaciente());

        return evaluacion;
    }

    public ArrayList<EvaluacionDto> generateEvaluationDTOS (ArrayList<Evaluacion> evaluacions)
    {
        int i;
        ArrayList<EvaluacionDto> wordDtos = new ArrayList<>();
        for (i = 0; i < evaluacions.size(); i++ )
        {
            wordDtos.add(evaluacionToEvaluacionDto(evaluacions.get(i)));
        }

        return wordDtos;
    }

    public EvaluacionDto evaluacionToEvaluacionDto (Evaluacion evaluacion){

        EvaluacionDto evaluacionDto = new EvaluacionDto();

        evaluacionDto.setId(evaluacion.getId());
        evaluacionDto.setMedicion1(evaluacion.getMedicion1());
        evaluacionDto.setMedicion2(evaluacion.getMedicion2());
        evaluacionDto.setMedicion3(evaluacion.getMedicion3());
        evaluacionDto.setMedicion4(evaluacion.getMedicion4());
        evaluacionDto.setMedicion5(evaluacion.getMedicion5());
        evaluacionDto.setMediana(evaluacion.getMediana());
        evaluacionDto.setScoreZ(evaluacion.getScoreZ());
        evaluacionDto.setSubtipoMedicion(evaluacion.getSubtipoMedicion());
        evaluacionDto.setTipoEvaluacion(evaluacion.getTipoEvaluacion());
        evaluacionDto.setPaciente(evaluacion.getPaciente());

        return evaluacionDto;
    }

}

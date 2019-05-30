package cl.sportapp.evaluation.controller;

import cl.sportapp.evaluation.dto.EvaluacionDto;
import cl.sportapp.evaluation.mapper.EvaluacionMapper;
import cl.sportapp.evaluation.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/evaluation")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private EvaluacionMapper evaluacionMapper;

    @PostMapping(value = "/all")
    @ResponseBody
    public ResponseEntity<ArrayList<EvaluacionDto>> getAllEvaluations()
    {
        try{
            return ResponseEntity.ok( evaluacionService.getAllEvaluation() );
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/{idPaciente}/{idSubtipoMedicion}/")
    @ResponseBody
    public ResponseEntity<EvaluacionDto> createNewEvaluation(@PathVariable("idPaciente") Long idPaciente,@PathVariable("idSubtipoMedicion") Long idSubtipoMedicion, @RequestBody EvaluacionDto evaluacionDto)
    {
        try{
            return ResponseEntity.ok(evaluacionMapper.evaluacionToEvaluacionDto( evaluacionService.newEvaluation(idPaciente,idSubtipoMedicion,evaluacionDto)) );
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<EvaluacionDto> findByIdUser(@PathVariable("id") Long id)
    {
        try{
            return ResponseEntity.ok( evaluacionMapper.evaluacionToEvaluacionDto(evaluacionService.findByEvaluation(id)));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<EvaluacionDto> updateUser(@PathVariable("id") Long id, @RequestBody EvaluacionDto userDto)
    {
        try{
            return ResponseEntity.ok(evaluacionMapper.evaluacionToEvaluacionDto( evaluacionService.updateEvaluation(id,userDto) ) );
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

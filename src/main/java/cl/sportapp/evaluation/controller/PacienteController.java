package cl.sportapp.evaluation.controller;

import cl.sportapp.evaluation.dto.PacienteDto;
import cl.sportapp.evaluation.mapper.PacienteMapper;
import cl.sportapp.evaluation.service.PacienteService;
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

@CrossOrigin
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteMapper pacienteMapper;

    @PostMapping(value = "/")
    @ResponseBody
    public ResponseEntity<PacienteDto> createNewPaciente(@RequestBody PacienteDto pacienteDto)
    {
        try{
            return ResponseEntity.ok(pacienteMapper.pacienteToPacienteDto( pacienteService.newUser(pacienteDto)) );
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<PacienteDto> findByIdPaciente(@PathVariable("id") Long id)
    {
        try{
            return ResponseEntity.ok( pacienteMapper.pacienteToPacienteDto(pacienteService.findByUser(id)));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<PacienteDto> updatePaciente(@PathVariable("id") Long id, @RequestBody PacienteDto pacienteDto)
    {
        try{
            return ResponseEntity.ok(pacienteMapper.pacienteToPacienteDto( pacienteService.updateUser(id,pacienteDto) ) );
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

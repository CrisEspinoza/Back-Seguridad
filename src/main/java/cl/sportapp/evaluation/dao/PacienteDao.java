package cl.sportapp.evaluation.dao;

import cl.sportapp.evaluation.entitie.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteDao extends JpaRepository<Paciente, Long> {


}

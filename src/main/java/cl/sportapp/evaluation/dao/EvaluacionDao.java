package cl.sportapp.evaluation.dao;

import cl.sportapp.evaluation.entitie.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface EvaluacionDao extends JpaRepository<Evaluacion, Long> {

    ArrayList<Evaluacion> findAll();
}

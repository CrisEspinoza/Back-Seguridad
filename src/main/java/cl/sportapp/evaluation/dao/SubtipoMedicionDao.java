package cl.sportapp.evaluation.dao;

import cl.sportapp.evaluation.entitie.SubtipoMedicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtipoMedicionDao extends JpaRepository<SubtipoMedicion, Long> {

    SubtipoMedicion findByNombre(String name);
}

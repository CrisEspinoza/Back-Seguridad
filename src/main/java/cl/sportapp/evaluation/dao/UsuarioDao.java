package cl.sportapp.evaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.sportapp.evaluation.entitie.Usuario;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);
    Boolean existsByEmail(String email);
    Usuario findById(Long id);
}

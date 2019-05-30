package cl.sportapp.evaluation.dao;

import cl.sportapp.evaluation.entitie.Role;
import cl.sportapp.evaluation.entitie.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}

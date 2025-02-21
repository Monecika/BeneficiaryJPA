package ceiti.md.beneficiaryfx.model.repositories;

import ceiti.md.beneficiaryfx.model.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
}

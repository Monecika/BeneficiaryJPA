package ceiti.md.beneficiaryfx.model.repositories;

import ceiti.md.beneficiaryfx.model.entities.Environments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnvironmentsRepository extends JpaRepository<Environments, Integer> {
    Environments findEnvironmentsByEnvironment(String environment);
}

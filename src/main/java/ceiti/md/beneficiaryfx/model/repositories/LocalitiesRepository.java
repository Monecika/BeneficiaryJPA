package ceiti.md.beneficiaryfx.model.repositories;

import ceiti.md.beneficiaryfx.model.entities.Localities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalitiesRepository extends JpaRepository<Localities, Integer> {
    Optional<Localities> findByLocalityName(String localityName);
}

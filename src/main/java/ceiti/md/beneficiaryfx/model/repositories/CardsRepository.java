package ceiti.md.beneficiaryfx.model.repositories;

import ceiti.md.beneficiaryfx.model.entities.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Integer> {
}

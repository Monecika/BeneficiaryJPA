package ceiti.md.beneficiaryfx.model.services;


import ceiti.md.beneficiaryfx.model.entities.Cards;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardsService implements MyCrudRepository<Cards> {
    @Override
    public List<Cards> findAll() {
        return List.of();
    }

    @Override
    public Optional<Cards> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Cards save(Cards entity) {
        return null;
    }

    @Override
    public void update(Cards entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}

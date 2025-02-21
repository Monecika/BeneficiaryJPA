package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Localities;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class LocalitiesService implements MyCrudRepository<Localities> {
    @Override
    public List<Localities> findAll() {
        return List.of();
    }

    @Override
    public Optional<Localities> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Localities save(Localities entity) {
        return null;
    }

    @Override
    public void update(Localities entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}
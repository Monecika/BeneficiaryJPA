package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Environments;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvironmentsService implements MyCrudRepository<Environments> {
    @Override
    public List<Environments> findAll() {
        return List.of();
    }

    @Override
    public Optional<Environments> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Environments save(Environments entity) {
        return null;
    }

    @Override
    public void update(Environments entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}
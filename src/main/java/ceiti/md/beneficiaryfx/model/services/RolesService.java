package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Roles;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService implements MyCrudRepository<Roles> {
    @Override
    public List<Roles> findAll() {
        return List.of();
    }

    @Override
    public Optional<Roles> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Roles save(Roles entity) {
        return null;
    }

    @Override
    public void update(Roles entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}
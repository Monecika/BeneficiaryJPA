package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Roles;
import ceiti.md.beneficiaryfx.model.repositories.RolesRepository;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService implements MyCrudRepository<Roles> {

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public ObservableList<Roles> findAll() {
        List<Roles> rolesList = rolesRepository.findAll();
        return FXCollections.observableArrayList(rolesList);
    }

    @Override
    public Optional<Roles> findById(int id) {
        return rolesRepository.findById(id);
    }

    @Override
    public void save(Roles entity) {
        rolesRepository.save(entity);
    }

    @Override
    public void update(Roles entity) {
            rolesRepository.save(entity);
    }

    @Override
    public void deleteById(Roles entity) {
            rolesRepository.delete(entity);
    }
}

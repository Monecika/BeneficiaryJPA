package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Environments;
import ceiti.md.beneficiaryfx.model.repositories.EnvironmentsRepository;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvironmentsService implements MyCrudRepository<Environments> {

    private final EnvironmentsRepository environmentsRepository;

    @Autowired
    public EnvironmentsService(EnvironmentsRepository environmentsRepository) {
        this.environmentsRepository = environmentsRepository;
    }

    @Override
    public ObservableList<Environments> findAll() {
        List<Environments> environmentsList = environmentsRepository.findAll();
        return FXCollections.observableArrayList(environmentsList);
    }

    @Override
    public Optional<Environments> findById(int id) {
        return environmentsRepository.findById(id);
    }

    @Override
    public void save(Environments entity) {
        environmentsRepository.save(entity);
    }

    @Override
    public void update(Environments entity) {
            environmentsRepository.save(entity);
    }

    @Override
    public void deleteById(Environments entity) {
            environmentsRepository.delete(entity);
    }
}

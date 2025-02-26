package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Localities;
import ceiti.md.beneficiaryfx.model.repositories.LocalitiesRepository;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalitiesService implements MyCrudRepository<Localities> {

    private final LocalitiesRepository localitiesRepository;

    @Autowired
    public LocalitiesService(LocalitiesRepository localitiesRepository) {
        this.localitiesRepository = localitiesRepository;
    }

    @Override
    public ObservableList<Localities> findAll() {
        List<Localities> localitiesList = localitiesRepository.findAll();
        return FXCollections.observableArrayList(localitiesList);
    }

    @Override
    public Optional<Localities> findById(int id) {
        return localitiesRepository.findById(id);
    }

    @Override
    public void save(Localities entity) {
        localitiesRepository.save(entity);
    }

    @Override
    public void update(Localities entity) {
        localitiesRepository.save(entity);
    }

    @Override
    public void deleteById(Localities entity) {
        localitiesRepository.delete(entity);
    }

    public Localities getLocality(String localityName) {
        return localitiesRepository.findByLocalityName(localityName)
                                   .orElse(null);
    }
}

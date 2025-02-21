package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.DisplayData;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisplayDataService implements MyCrudRepository<DisplayData> {
    @Override
    public List<DisplayData> findAll() {
        return List.of();
    }

    @Override
    public Optional<DisplayData> findById(int id) {
        return Optional.empty();
    }

    @Override
    public DisplayData save(DisplayData entity) {
        return null;
    }

    @Override
    public void update(DisplayData entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}
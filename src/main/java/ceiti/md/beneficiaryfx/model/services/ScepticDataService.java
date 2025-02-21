package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.ScepticData;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScepticDataService implements MyCrudRepository<ScepticData> {
    @Override
    public List<ScepticData> findAll() {
        return List.of();
    }

    @Override
    public Optional<ScepticData> findById(int id) {
        return Optional.empty();
    }

    @Override
    public ScepticData save(ScepticData entity) {
        return null;
    }

    @Override
    public void update(ScepticData entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}
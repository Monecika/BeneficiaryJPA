package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Beneficiaries;
import ceiti.md.beneficiaryfx.model.repositories.BeneficiariesRepository;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiariesService implements MyCrudRepository<Beneficiaries> {
    private BeneficiariesRepository beneficiariesRepository;

    public BeneficiariesService() {
    }

    @Override
    public List<Beneficiaries> findAll() {
        return beneficiariesRepository.findAll();
    }

    @Override
    public Optional<Beneficiaries> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Beneficiaries save(Beneficiaries entity) {
        return null;
    }

    @Override
    public void update(Beneficiaries entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}
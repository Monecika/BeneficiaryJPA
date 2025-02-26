package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Beneficiaries;
import ceiti.md.beneficiaryfx.model.repositories.BeneficiariesRepository;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiariesService implements MyCrudRepository<Beneficiaries> {

    private final BeneficiariesRepository beneficiariesRepository;

    @Autowired
    public BeneficiariesService(BeneficiariesRepository beneficiariesRepository) {
        this.beneficiariesRepository = beneficiariesRepository;
    }

    @Override
    public ObservableList<Beneficiaries> findAll() {
        List<Beneficiaries> beneficiariesList = beneficiariesRepository.findAll();
        return FXCollections.observableArrayList(beneficiariesList);
    }

    @Override
    public Optional<Beneficiaries> findById(int id) {
        return beneficiariesRepository.findById(id);
    }

    @Override
    public void save(Beneficiaries entity) {
        beneficiariesRepository.save(entity);
    }

    @Override
    public void update(Beneficiaries entity) {
        beneficiariesRepository.save(entity);
    }

    @Override
    public void deleteById(Beneficiaries entity) {
        beneficiariesRepository.delete(entity);
    }

    public Beneficiaries getBeneficiary(String codeBen) {
        return beneficiariesRepository.findByCodeBen(codeBen)
                                      .orElse(null);
    }

    public void deleteByNrBen(String code) {
        beneficiariesRepository.deleteByCodeBen(code);
    }
}

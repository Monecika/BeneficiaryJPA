package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Beneficiaries;
import ceiti.md.beneficiaryfx.model.entities.ScepticData;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScepticDataService implements MyCrudRepository<ScepticData> {
    private final BeneficiariesService beneficiariesService;

    @Autowired
    public ScepticDataService(BeneficiariesService beneficiariesService) {
        this.beneficiariesService = beneficiariesService;
    }

    @Override
    public ObservableList<ScepticData> findAll() {

        ObservableList<Beneficiaries> beneficiariesList = beneficiariesService.findAll();
        ObservableList<ScepticData> scepticDataList = FXCollections.observableArrayList();

        ScepticData scepticData;
        Beneficiaries beneficiaries;

        while (!beneficiariesList.isEmpty()) {
            beneficiaries = beneficiariesList.getFirst();
            scepticData = new ScepticData(beneficiaries.getID(), beneficiaries.getCodeBen(),
                    beneficiaries.getNameBen(), beneficiaries.getSurnameBen(), beneficiaries.getPhoneBen(),
                    beneficiaries.getAddressBen(), beneficiaries.getEmailBen());
            scepticDataList.add(scepticData);
            beneficiariesList.removeFirst();
        }
        return scepticDataList;
    }

    @Override
    public Optional<ScepticData> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(ScepticData entity) {
    }

    @Override
    public void update(ScepticData entity) {

    }

    @Override
    public void deleteById(ScepticData entity) {

    }
}
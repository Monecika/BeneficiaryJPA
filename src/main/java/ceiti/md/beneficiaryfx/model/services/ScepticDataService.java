package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Beneficiaries;
import ceiti.md.beneficiaryfx.model.entities.ScepticData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScepticDataService {
    private final BeneficiariesService beneficiariesService;

    @Autowired
    public ScepticDataService(BeneficiariesService beneficiariesService) {
        this.beneficiariesService = beneficiariesService;
    }

    public ObservableList<ScepticData> findAll() {
        ObservableList<Beneficiaries> beneficiariesList = beneficiariesService.findAll();
        ObservableList<ScepticData> scepticDataList = FXCollections.observableArrayList();

        for (Beneficiaries beneficiary : beneficiariesList) {
            ScepticData scepticData = new ScepticData(beneficiary.getCodeBen(), beneficiary.getNameBen(),
                    beneficiary.getSurnameBen(), beneficiary.getPhoneBen(), beneficiary.getAddressBen(),
                    beneficiary.getEmailBen());
            scepticDataList.add(scepticData);
        }

        return scepticDataList;
    }
}

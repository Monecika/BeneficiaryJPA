package ceiti.md.beneficiaryfx.model;

import ceiti.md.beneficiaryfx.model.entities.*;
import ceiti.md.beneficiaryfx.model.services.*;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainModel {

    private final DisplayDataService displayDataService;
    private final ScepticDataService scepticDataService;
    private final BeneficiariesService beneficiariesService;
    private final EnvironmentsService environmentsService;
    private final LocalitiesService localitiesService;
    private final CardsService cardsService;

    @Autowired
    public MainModel(DisplayDataService displayDataService, ScepticDataService scepticDataService,
                     BeneficiariesService beneficiariesService, EnvironmentsService environmentsService,
                     LocalitiesService localitiesService, CardsService cardsService) {
        this.displayDataService = displayDataService;
        this.scepticDataService = scepticDataService;
        this.beneficiariesService = beneficiariesService;
        this.environmentsService = environmentsService;
        this.localitiesService = localitiesService;
        this.cardsService = cardsService;
    }

    public ObservableList<DisplayData> getAllDisplayData() {
        return displayDataService.findAll();
    }

    public ObservableList<ScepticData> getScepticDisplayData() {
        return scepticDataService.findAll();
    }

    public void deleteBen(String codeBen) {
        Beneficiaries beneficiaries;
        beneficiaries = beneficiariesService.getBeneficiary(codeBen);
        beneficiariesService.deleteById(beneficiaries);
    }

    public void updateDisplayData(DisplayData displayData) {
        displayDataService.update(displayData);
    }

    public void addNewUser(DisplayData displayData) {
        displayDataService.save(displayData);
    }

    public ObservableList<Environments> getEnvironment() {
        return environmentsService.findAll();
    }

    public ObservableList<Localities> getLocality() {
        return localitiesService.findAll();
    }

    public ObservableList<Cards> getCard() {
        return cardsService.findAll();
    }
}

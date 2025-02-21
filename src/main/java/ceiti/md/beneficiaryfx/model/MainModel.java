package ceiti.md.beneficiaryfx.model;

import ceiti.md.beneficiaryfx.model.entities.Cards;
import ceiti.md.beneficiaryfx.model.entities.DisplayData;
import ceiti.md.beneficiaryfx.model.entities.Environments;
import ceiti.md.beneficiaryfx.model.entities.Localities;
import ceiti.md.beneficiaryfx.model.services.*;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class MainModel {
    private final DisplayDataService displayDataService;
    private final ScepticDataService scepticDataService;
    private final BeneficiariesService beneficiariesService;
    private final EnvironmentsService environmentsService;
    private final LocalitiesService localitiesService;
    private final CardsService cardsService;

    public MainModel() {
        displayDataService = new DisplayDataService();
        scepticDataService = new ScepticDataService();
        beneficiariesService = new BeneficiariesService();
        environmentsService = new EnvironmentsService();
        localitiesService = new LocalitiesService();
        cardsService = new CardsService();
    }

    public ObservableList<DisplayData> getAllDisplayData() {
        return null;
    }

    public ObservableList<DisplayData> getScepticDisplayData() {
        return null;
    }

    public void deleteBen(String number) {
    }

    public void updateDisplayData(DisplayData displayData) {
    }

    public void addNewUser(DisplayData displayData) throws SQLException {
    }

    public ObservableList<Environments> getEnvironment() {
        return null;
    }

    public ObservableList<Localities> getLocality() {
        return null;
    }

    public ObservableList<Cards> getCard() {
        return null;
    }
}

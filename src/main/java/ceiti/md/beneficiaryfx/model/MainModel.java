package ceiti.md.beneficiaryfx.model;

import ceiti.md.beneficiaryfx.model.entity.Cards;
import ceiti.md.beneficiaryfx.model.entity.DisplayData;
import ceiti.md.beneficiaryfx.model.entity.Environments;
import ceiti.md.beneficiaryfx.model.entity.Localities;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class MainModel {

    public MainModel() {
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

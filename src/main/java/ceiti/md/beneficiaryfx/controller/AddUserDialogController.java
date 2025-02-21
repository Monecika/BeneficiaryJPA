package ceiti.md.beneficiaryfx.controller;

import ceiti.md.beneficiaryfx.model.entities.Cards;
import ceiti.md.beneficiaryfx.model.entities.DisplayData;
import ceiti.md.beneficiaryfx.model.entities.Environments;
import ceiti.md.beneficiaryfx.model.entities.Localities;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


public class AddUserDialogController {

    private boolean addButtonClicked = false;

    public DisplayData getTheData(String name, String surname, String address, String phone, String idnp,
                                  String email, String locality, String environment, String card) {
        return new DisplayData("", name, surname, phone, idnp, address, email, locality, environment, card);
    }

    public DisplayData showAddUserDialog(ObservableList<Localities> locality,
                                         ObservableList<Environments> environment, ObservableList<Cards> card) {
        Dialog<DisplayData> dialog = new Dialog<>();
        dialog.setTitle("Add User");

        DialogPane dialogPane = new DialogPane();
        dialog.setDialogPane(dialogPane);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        TextField nameField = new TextField();
        TextField surnameField = new TextField();
        TextField addressField = new TextField();
        TextField phoneField = new TextField();
        TextField idnpField = new TextField();
        TextField emailField = new TextField();

        ComboBox<String> environmentBox = new ComboBox<>();
        ComboBox<String> localityBox = new ComboBox<>();
        ComboBox<String> cardBox = new ComboBox<>();

        environmentBox.getItems()
                      .addAll(environment.stream()
                                         .map(Environments::getEnvironment)
                                         .toList());
        localityBox.getItems()
                   .addAll(locality.stream()
                                   .map(Localities::getLocalityName)
                                   .toList());
        cardBox.getItems()
               .addAll(card.stream()
                           .map(Cards::getCardNr)
                           .toList());

        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Surname:"), 0, 1);
        grid.add(surnameField, 1, 1);
        grid.add(new Label("Address:"), 0, 2);
        grid.add(addressField, 1, 2);
        grid.add(new Label("Phone:"), 0, 3);
        grid.add(phoneField, 1, 3);
        grid.add(new Label("IDNP:"), 0, 4);
        grid.add(idnpField, 1, 4);
        grid.add(new Label("Email:"), 0, 5);
        grid.add(emailField, 1, 5);
        grid.add(new Label("Environment:"), 0, 6);
        grid.add(environmentBox, 1, 6);
        grid.add(new Label("Locality:"), 0, 7);
        grid.add(localityBox, 1, 7);
        grid.add(new Label("Card:"), 0, 8);
        grid.add(cardBox, 1, 8);

        dialogPane.setContent(grid);

        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        ButtonType closeButtonType = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane()
              .getButtonTypes()
              .addAll(addButtonType, closeButtonType)
        ;

        dialog.setResultConverter(buttonType -> {
            if (buttonType == addButtonType) {
                addButtonClicked = true;
                return getTheData(nameField.getText(), surnameField.getText(), addressField.getText(),
                        phoneField.getText(), idnpField.getText(), emailField.getText(), localityBox.getValue(),
                        environmentBox.getValue(), cardBox.getValue());
            } else {
                addButtonClicked = false;
                return null;
            }
        });

        dialog.showAndWait();

        return addButtonClicked ? getTheData(nameField.getText(), surnameField.getText(), addressField.getText(),
                phoneField.getText(), idnpField.getText(), emailField.getText(), localityBox.getValue(),
                environmentBox.getValue(), cardBox.getValue()) : null;
    }
}

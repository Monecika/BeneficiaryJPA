package ceiti.md.beneficiaryfx.controller;

import ceiti.md.beneficiaryfx.model.MainModel;
import ceiti.md.beneficiaryfx.model.entities.DisplayData;
import ceiti.md.beneficiaryfx.model.services.ReportService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;

@Controller
public class MainController {

    private final ExportHandler exportHandler = new ExportHandler();
    private final int nameColumnIndex = 1;
    private final int surnameColumnIndex = 2;
    private final int localityColumnIndex = 7;
    private final boolean isAllDataDisplayed = true;
    private final MainModel model;
    private final ReportService reportService;
    @FXML
    private TableView<DisplayData> tableView;
    @FXML
    private MenuItem updateUser;
    @FXML
    private MenuItem filterName;
    @FXML
    private MenuItem filterSurname;
    @FXML
    private MenuItem filterLocality;
    @FXML
    private MenuItem toggleSearch;
    @FXML
    private javafx.scene.control.TextField searchField;
    @FXML
    private javafx.scene.control.Button themeButton;

    private ObservableList<DisplayData> currentData;
    private boolean isSearchToggled = false;
    private boolean isDarkTheme = false;
    private boolean isTableEditable = false;

    @Autowired
    public MainController(MainModel model, ReportService reportService) {
        this.model = model;
        this.reportService = reportService;
    }

    @FXML
    public void initialize() {
        loadAllData();
        tableView.setEditable(false);
        tableView.getColumns()
                 .forEach(column -> column.setSortable(false));
        if (!tableView.getColumns()
                      .isEmpty()) {
            tableView.getColumns()
                     .get(0)
                     .setSortable(true)
            ;
        }
        searchField.textProperty()
                   .addListener((observable, oldValue, newValue) -> applySearchFilter(newValue));
    }

    @FXML
    private void enableSortByName() {
        toggleColumnSorting(nameColumnIndex, filterName);
    }

    @FXML
    private void enableSortBySurname() {
        toggleColumnSorting(surnameColumnIndex, filterSurname);
    }

    @FXML
    public void enableSortByLocality() {
        toggleColumnSorting(localityColumnIndex, filterLocality);
    }

    @FXML
    private void toggleTheme() {
        isDarkTheme = !isDarkTheme;
        changeTheme();
        updateThemeIcon();
    }

    @FXML
    private void toggleSearch() {
        isSearchToggled = !isSearchToggled;
        toggleSearch.setText(addOrRemoveTick(toggleSearch.getText(), isSearchToggled));
        searchField.setDisable(!isSearchToggled);
    }

    @FXML
    private void loadAllData() {
        currentData = model.getAllDisplayData();
        createTableColumns(getAllDataColumns(), getAllDataPropertyNames());
        tableView.setItems(currentData);

        adjustTableSize();
    }

    @FXML
    private void loadScepticData() {
        currentData = FXCollections.observableArrayList(model.getScepticDisplayData());

        createTableColumns(getScepticDataColumns(), getScepticDataPropertyNames());
        tableView.setItems(currentData);

        adjustTableSize();
    }


    @FXML
    private void showRuralData() {
        loadAllData();
        if (currentData != null) {
            ObservableList<DisplayData> ruralData = currentData.filtered(data -> data.getEnvironment() != null &&
                    "rural".equalsIgnoreCase(data.getEnvironment()));
            tableView.setItems(ruralData);
        } else {
            tableView.setItems(FXCollections.observableArrayList());
        }
    }


    @FXML
    private void showAddUserPopup() {
        try {
            AddUserDialogController addUserDialogController = new AddUserDialogController();
            DisplayData data = addUserDialogController.showAddUserDialog(model.getLocality(), model.getEnvironment());
            if (data != null) {
                model.addNewUser(data);
                loadAllData();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void toggleTableEditability() {
        isTableEditable = !isTableEditable;
        tableView.setEditable(isTableEditable);
        updateUser.setText(isTableEditable ? "Revert to View Mode" : "Update User");
        if (!isTableEditable) {
            tableView.getColumns()
                     .forEach(column -> column.setEditable(false));
            tableView.getItems()
                     .forEach(item -> tableView.getSelectionModel()
                                               .clearSelection());
        } else {
            makeColumnsEditable();
        }
    }

    @FXML
    private void exportUsersButtonAction() {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters()
//                   .addAll(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"), new FileChooser.ExtensionFilter(
//                           "Excel Files", "*.xlsx"));
//        fileChooser.setInitialDirectory(new java.io.File(System.getProperty("user.home")));
//        java.io.File selectedFile = fileChooser.showSaveDialog(themeButton.getScene()
//                                                                          .getWindow());
//        if (selectedFile != null) {
//            String filePath = selectedFile.getAbsolutePath();
//            exportHandler.handleExportRequest(tableView, filePath);
//        }
        reportService.exportReport("pdf");
    }

    private void changeTheme() {
        String theme = isDarkTheme ? "dark.css" : "light.css";
        String cssFilePath = "/ceiti/md/beneficiaryfx/css/" + theme;
        URL cssFileURL = getClass().getResource(cssFilePath);
        if (cssFileURL != null) {
            applyStylesheet(cssFileURL);
        } else {
            System.err.println("CSS file not found: " + cssFilePath);
        }
    }

    private void updateThemeIcon() {
        String iconPath = isDarkTheme ? "/ceiti/md/beneficiaryfx/icons/themeIcons/light_theme.png" : "/ceiti/md" +
                "/beneficiaryfx/icons/themeIcons/dark_theme.png";
        Image icon = new Image(getClass().getResource(iconPath)
                                         .toExternalForm());
        ImageView imageView = new ImageView(icon);
        imageView.setFitHeight(16);
        imageView.setFitWidth(16);
        themeButton.setGraphic(imageView);
    }

    private void applyStylesheet(URL cssFileURL) {
        Scene scene = themeButton.getScene();
        if (scene != null) {
            scene.getStylesheets()
                 .clear();
            scene.getStylesheets()
                 .add(cssFileURL.toExternalForm());
        }
    }

    private void applySearchFilter(String filter) {
        if (filter.isEmpty()) {
            tableView.setItems(currentData);
        } else {
            ObservableList<DisplayData> filteredList = currentData.filtered(data -> data.getName()
                                                                                        .toLowerCase()
                                                                                        .contains(filter.toLowerCase()) || data.getSurname()
                                                                                                                               .toLowerCase()
                                                                                                                               .contains(filter.toLowerCase()) || data.getLocality()
                                                                                                                                                                      .toLowerCase()
                                                                                                                                                                      .contains(filter.toLowerCase()));
            tableView.setItems(filteredList);
        }
    }

    private TableCell<DisplayData, String> createOperationsCell() {
        return new TableCell<DisplayData, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText("Delete");
                    setStyle("-fx-text-fill: red; -fx-font-weight: bold; -fx-alignment: CENTER;");
                    setOnMouseClicked(mouseEvent -> {
                        DisplayData data = getTableRow().getItem();
                        if (data != null) {
                            currentData.remove(data);
                            model.deleteBen(data.getCodeBen());
                        }
                    });
                }
            }
        };
    }

    private void updateTableRow(TableColumn.CellEditEvent<DisplayData, String> event, String columnName) {
        DisplayData data = event.getRowValue();
        String newValue = event.getNewValue();
        switch (columnName) {
            case "Name" -> data.setName(newValue);
            case "Surname" -> data.setSurname(newValue);
            case "Phone Number" -> data.setPhoneNumber(newValue);
            case "IDNP" -> data.setCodeBen(newValue);
            case "Address" -> data.setAddress(newValue);
            case "Email" -> data.setEmail(newValue);
        }
        model.updateDisplayData(data);
    }

    private void makeColumnsEditable() {
        tableView.getColumns()
                 .forEach(column -> column.setEditable(!column.getText()
                                                              .equals("BeneficiaryId") && !column.getText()
                                                                                                 .equals("Environment"
                                                                                                 ) && !column.getText()
                                                                                                                                  .equals("CardNumber") && !column.getText()
                                                                                                                                                                  .equals("Locality")));
    }

    private void toggleColumnSorting(int columnIndex, MenuItem menuItem) {
        TableColumn<DisplayData, ?> column = tableView.getColumns()
                                                      .get(columnIndex);
        boolean isSortable = !column.isSortable();
        column.setSortable(isSortable);
        menuItem.setText(addOrRemoveTick(menuItem.getText(), isSortable));
    }

    private void createTableColumns(String[] columnNames, String[] propertyNames) {
        tableView.getColumns()
                 .clear();
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn<DisplayData, String> column = new TableColumn<>(columnNames[i]);
            if (!columnNames[i].equals("Operations")) {
                column.setCellValueFactory(new PropertyValueFactory<>(propertyNames[i]));
            }
            column.setResizable(false);
            column.setSortable(false);
            if (columnNames[i].equals("BeneficiaryId")) {
                column.setSortable(true);
            }
            if (columnNames[i].equals("Operations")) {
                column.setCellFactory(cell -> createOperationsCell());
            } else {
                column.setCellFactory(TextFieldTableCell.forTableColumn());
                int finalI = i;
                column.setOnEditCommit(event -> updateTableRow(event, columnNames[finalI]));
            }
            column.setStyle("-fx-alignment: CENTER;");
            column.setPrefWidth(columnNames[i].equals("Email") ? 180 : 129);
            if (columnNames[i].equals("Operations") || isAllDataDisplayed || isColumnRelevant(columnNames[i])) {
                tableView.getColumns()
                         .add(column);
            }
        }
    }

    private String addOrRemoveTick(String text, boolean value) {
        return value ? text + " ✔" : text.replace(" ✔", "");
    }

    private boolean isColumnRelevant(String columnName) {
        return switch (columnName) {
            case "BeneficiaryId", "Name", "Surname", "Phone Number", "Address", "Email", "Operations" -> true;
            default -> false;
        };
    }

    private String[] getAllDataColumns() {
        return new String[]{"BeneficiaryId", "Name", "Surname", "Phone Number", "IDNP", "Address", "Email", "Locality"
                , "Environment", "CardNumber", "Operations"};
    }

    private String[] getAllDataPropertyNames() {
        return new String[]{"codeBen", "name", "surname", "phoneNumber", "idnp", "address", "email", "locality",
                "environment", "cardNumber", "operations"};
    }

    private String[] getScepticDataColumns() {
        return new String[]{"BeneficiaryId", "Name", "Surname", "Phone Number", "Address", "Email", "Operations"};
    }

    private String[] getScepticDataPropertyNames() {
        return new String[]{"codeBen", "name", "surname", "phoneNumber", "address", "email", "operations"};
    }

    private void adjustTableSize() {
        double columnWidth = 135;
        int columnCount = tableView.getColumns()
                                   .size();

        double newWidth = columnWidth * columnCount;
        tableView.setPrefWidth(newWidth);
        tableView.setMinWidth(newWidth);
        tableView.setMaxWidth(newWidth);
    }

}

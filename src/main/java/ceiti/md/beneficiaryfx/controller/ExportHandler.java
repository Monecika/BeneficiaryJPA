package ceiti.md.beneficiaryfx.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExportHandler {
    private int number;

    public void exportToPDF(TableView<?> table, String filePath) {
        number = table.getColumns().size() - 1;

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            PdfPTable pdfTable = new PdfPTable(number);
            pdfTable.setWidthPercentage(100);

            for (int i = 0; i < number; i++) {
                TableColumn<?, ?> column = table.getColumns().get(i);
                pdfTable.addCell(new PdfPCell(new Phrase(column.getText())));
            }

            for (int row = 0; row < table.getItems().size(); row++) {
                for (int col = 0; col < number; col++) {
                    Object cellData = table.getColumns().get(col).getCellData(row);
                    String value = (cellData != null) ? cellData.toString() : "";
                    pdfTable.addCell(new PdfPCell(new Phrase(value)));
                }
            }

            document.add(pdfTable);
            document.close();

            showAlert(AlertType.INFORMATION, "Success", "Data exported to PDF successfully!");
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Error", "Error exporting to PDF: " + e.getMessage());
        }
    }

    public void exportToExcel(TableView<?> table, String filePath) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Data");

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < number; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(table.getColumns().get(i).getText());
            }

            for (int row = 0; row < table.getItems().size(); row++) {
                Row excelRow = sheet.createRow(row + 1);
                for (int col = 0; col < number; col++) {
                    Cell cell = excelRow.createCell(col);
                    Object value = table.getColumns().get(col).getCellData(row);
                    cell.setCellValue(value == null ? "" : value.toString());
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            showAlert(AlertType.INFORMATION, "Success", "Data exported to Excel successfully!");
        } catch (IOException e) {
            showAlert(AlertType.ERROR, "Error", "Error exporting to Excel: " + e.getMessage());
        }
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void handleExportRequest(TableView<?> table, String filePath) {
        if (filePath.endsWith(".pdf")) {
            exportToPDF(table, filePath);
        } else if (filePath.endsWith(".xlsx")) {
            exportToExcel(table, filePath);
        } else {
            showAlert(AlertType.ERROR, "Invalid File", "Please specify a valid file extension (.pdf or .xlsx)");
        }
    }
}

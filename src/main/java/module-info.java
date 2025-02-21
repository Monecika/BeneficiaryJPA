module ceiti.md.beneficiaryfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires itextpdf;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens ceiti.md.beneficiaryfx to javafx.fxml;
    opens ceiti.md.beneficiaryfx.controller to javafx.fxml;
    exports ceiti.md.beneficiaryfx;
}

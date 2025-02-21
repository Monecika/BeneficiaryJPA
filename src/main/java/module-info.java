module ceiti.md.beneficiaryfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires itextpdf;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires jakarta.persistence;
    requires static lombok;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.context;
    requires spring.beans;

    opens ceiti.md.beneficiaryfx to javafx.fxml;
    opens ceiti.md.beneficiaryfx.controller to javafx.fxml;
    exports ceiti.md.beneficiaryfx;
}

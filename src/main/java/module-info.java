module ceiti.md.beneficiaryfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.beans;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires spring.jdbc;
    requires spring.orm;
    requires spring.tx;
    requires spring.core;
    requires static lombok;
    requires itextpdf;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens ceiti.md.beneficiaryfx to javafx.fxml, spring.core;
    opens ceiti.md.beneficiaryfx.controller to javafx.fxml, spring.core, spring.beans;
    opens ceiti.md.beneficiaryfx.model to javafx.base, spring.core, spring.beans;
    opens ceiti.md.beneficiaryfx.model.entities to javafx.base, spring.core, org.hibernate.orm.core;
    opens ceiti.md.beneficiaryfx.model.repositories to spring.core;
    opens ceiti.md.beneficiaryfx.model.services to spring.core, spring.beans;

    exports ceiti.md.beneficiaryfx.model to spring.beans;

    exports ceiti.md.beneficiaryfx;
}

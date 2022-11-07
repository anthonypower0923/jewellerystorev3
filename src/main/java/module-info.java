module com.example.jewellerystorev3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires xstream;

    opens com.example.jewellerystorev3 to javafx.fxml;
    exports com.example.jewellerystorev3;
}
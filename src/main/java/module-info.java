module com.qaisr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.qaisr to javafx.fxml;
    opens com.qaisr.ui to javafx.fxml;
    exports com.qaisr;
    exports com.qaisr.ui;
    exports com.qaisr.model;
    exports com.qaisr.service;
    exports com.qaisr.config;
    exports com.qaisr.util;
}

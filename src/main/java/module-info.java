module com.uq.domi.domicilios {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.uq.domi to javafx.fxml;
    exports com.uq.domi;
    exports com.uq.domi.logic;
    opens com.uq.domi.logic to javafx.fxml;
}
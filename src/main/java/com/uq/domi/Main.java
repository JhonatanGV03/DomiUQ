package com.uq.domi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/domi/img/domi.png")));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("domi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 450);
        stage.setResizable(false);
        stage.getIcons().add(image);
        stage.setTitle("Domi");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
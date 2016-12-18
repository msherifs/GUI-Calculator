package com.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by mohamedsherif on 12/18/16.
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
         * Main Stage Initialization
         */
        Parent root = FXMLLoader.load(getClass().getResource("com/gui/fxml/"));
        primaryStage.setScene(new Scene(root,800,800));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.gui;

import com.calculator.number_system_converter.Hexadecimal;
import com.calculator.number_system_converter.NumberType;
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
    public static double mainStagePosX;
    public static double mainStagePosY;
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
         * Main Stage Initialization
         */
        Parent root = FXMLLoader.load(getClass().getResource("fxml/MainView.fxml"));
        primaryStage.setScene(new Scene(root,800,600));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        mainStagePosX = primaryStage.getX();
        mainStagePosY = primaryStage.getY();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

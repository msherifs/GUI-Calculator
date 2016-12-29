package com.gui.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by mohamedsherif on 12/18/16.
 */
public class Main extends Application{
    public static double mainStagePosX;
    public static double mainStagePosY;
    ScreensController mainScreen;
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
         * ScreensController Initialization
         * adding All Views to the mainScreen
         */

        mainScreen = new ScreensController();
        mainScreen.loadScreen("MainView","MainView.fxml");
        mainScreen.loadScreen("Arthimatic", "Arthimatic.fxml");
        mainScreen.setScreen("MainView");
        Group root = new Group();
        root.getChildren().addAll(mainScreen);
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(new Color(0.247,0.318,0.71,1));
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        mainStagePosX = primaryStage.getX();
        mainStagePosY = primaryStage.getY();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

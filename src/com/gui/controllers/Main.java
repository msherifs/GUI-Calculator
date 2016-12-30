package com.gui.controllers;

import Jama.Matrix;
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
        mainScreen.loadScreen("Plotting", "EquationPlotter.fxml");
        mainScreen.loadScreen("LinearSolver", "LinearSolver.fxml");
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
        double[][] lhsArray = {{3, 2, -1}, {2, -2, 4}, {-1, 0.5, -1}};
        double[] rhsArray = {1, -2, 0};
        //Creating Matrix Objects with arrays
        Matrix lhs = new Matrix(lhsArray);
        Matrix rhs = new Matrix(rhsArray, 3);
        //Calculate Solved Matrix
        Matrix ans = lhs.solve(rhs);
        //Printing Answers
        System.out.println("x = " + (ans.get(0, 0)));
        System.out.println("y = " + (ans.get(1, 0)));
        System.out.println("z = " + (ans.get(2, 0)));


        launch(args);
    }
}

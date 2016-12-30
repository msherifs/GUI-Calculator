package com.gui.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by mohamedsherif on 12/19/16.
 */
public class MainViewController implements ControlledScreen{
    @FXML
    AnchorPane decorationPanel;
    @FXML
    AnchorPane mainPanel;
    @FXML
    JFXHamburger hamburger;
    @FXML
    JFXDrawer drawer;
    @FXML
    StackPane stackPane;
    VBox box;
    ScreensController myScreen;


    private double xOffset;
    private double yOffset;
    Stage mainStage;

    public void initialize() {
        decorationPanel.toFront();

        try {
            box = FXMLLoader.load(getClass().getResource("DrawerPane.fxml"));
            drawer.setSidePane(box);

        } catch (IOException ex) {
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isShown()) {
                drawer.close();
            } else
                drawer.open();
        });

        box.getChildren().get(1).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                arthimaticButtonPressed();
            }
        });

        box.getChildren().get(4).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myScreen.setScreen("Plotting");
            }
        });
        box.getChildren().get(2).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myScreen.setScreen("Unit");
            }
        });
        box.getChildren().get(3).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myScreen.setScreen("NumberSystem");
            }
        });


        box.getChildren().get(5).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myScreen.setScreen("LinearSolver");
            }
        });

        box.getChildren().get(7).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                exitApplication();
            }
        });

        decorationPanel.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = Main.mainStagePosX - event.getScreenX();
                yOffset = Main.mainStagePosY - event.getScreenY();
            }
        });
        decorationPanel.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainStage = (Stage) decorationPanel.getScene().getWindow();
                mainStage.setX(event.getScreenX() + xOffset);
                mainStage.setY(event.getScreenY() + yOffset);
            }
        });


    }

    public void arthimaticButtonPressed() {
        drawer.close();
        myScreen.setScreen("Arthimatic");
    }

    public void exitApplication() {
        System.exit(0);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myScreen = screenPage;
    }
}

package com.gui.controllers;

import com.gui.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mohamedsherif on 12/19/16.
 */
public class MainViewController {
    @FXML
    AnchorPane decorationPanel;
    @FXML
    AnchorPane mainPanel;
    @FXML
    JFXHamburger hamburger;
    @FXML
    JFXDrawer drawer;
    VBox box;


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
        try {
            decorationPanel = FXMLLoader.load(getClass().getResource("Arthimatic.fxml"));
        } catch (IOException ex) {
        }

    }

    public void exitApplication() {
        System.exit(0);
    }
}

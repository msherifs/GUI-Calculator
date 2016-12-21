package com.gui.controllers;

import com.gui.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by mohamedsherif on 12/19/16.
 */
public class MainViewController {
    @FXML AnchorPane decorationPanel;
    @FXML AnchorPane mainPanel;
    private double xOffset;
    private double yOffset;
    Stage mainStage;
    public void initialize(){

//        mainStage = (Stage) decorationPanel.getScene().getWindow();
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
    public void exitApplication(){
        System.exit(0);
    }
}

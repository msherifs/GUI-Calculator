package com.gui.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

/**
 * Created by mohamedhisham on 12/29/16.
 */
public class unitConverterController implements ControlledScreen {

    @FXML
    JFXTextField theNumber ;
    @FXML
    JFXComboBox<String> choosenOperation ;

    ScreensController myScreen;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myScreen = screenPage;
    }
    public void returnMainView(){
        myScreen.setScreen("MainView");
    }
    public void initialize() {

        choosenOperation.getItems().add(0, "  Feet to Meter");
        choosenOperation.getItems().add(1,"   Kilogram to Gram");
        choosenOperation.getItems().add(2, " Kilometer to Meter");
        choosenOperation.getItems().add(3, );

    }


    public void convert () {
        if (choosenOperation.getSelectionModel().isSelected(0))
        {





    }
    }





}

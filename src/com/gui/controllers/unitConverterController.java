package com.gui.controllers;

import com.calculator.unit_converter.FeetToMeter;
import com.calculator.unit_converter.KilogramToGram;
import com.calculator.unit_converter.KilometerToMeter;
import com.calculator.unit_converter.UnitConverter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class unitConverterController implements ControlledScreen {

    @FXML
    JFXTextField theNumber ;
    @FXML
    JFXComboBox<String> choosenOperation ;

    ScreensController myScreen;
    UnitConverter converter;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myScreen = screenPage;
    }
    public void returnMainView(){
        myScreen.setScreen("MainView");
    }
    public void initialize() {
        choosenOperation.getItems().add(0, "Feet to Meter");
        choosenOperation.getItems().add(1,"Kilogram to Gram");
        choosenOperation.getItems().add(2, "Kilometer to Meter");
        choosenOperation.getItems().add(3,"Meter to Feet ");
        choosenOperation.getItems().add(4,"Gram to Kilogram");
        choosenOperation.getItems().add(4,"Meter to Kilometer");

    }


    public void convert () {
        switch (choosenOperation.getSelectionModel().getSelectedIndex()) {
            case 0:
                converter = new FeetToMeter(Double.parseDouble(theNumber.getText()),false);
                break;
            case 1 :
                converter = new KilogramToGram(Double.parseDouble(theNumber.getText()),false);
                break;
            case 2:
                converter = new KilometerToMeter(Double.parseDouble(theNumber.getText()),false);
                break;
            case 3:
                converter = new FeetToMeter(Double.parseDouble(theNumber.getText()),true);
                break;
            case 4:
                converter = new KilogramToGram(Double.parseDouble(theNumber.getText()),true);
                break;
            case 5:
                converter = new KilometerToMeter(Double.parseDouble(theNumber.getText()),true);

        }
        theNumber.setText(converter.convert() +"");



    }

}

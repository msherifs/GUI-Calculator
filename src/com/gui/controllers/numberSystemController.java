package com.gui.controllers;

import com.calculator.number_system_converter.*;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class numberSystemController  implements ControlledScreen{
    ScreensController myScreen;
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myScreen = screenPage;
    }
    @FXML
    JFXTextField theNumber ;
    @FXML
    JFXComboBox<String> choosenOperation ;
    NumberSystemConverter converter;
    NumberType type;
    NumberType needed ;
    public void initialize() {
        choosenOperation.getItems().add(0, "Binary to Decimal");
        choosenOperation.getItems().add(1,"Binary to Octal");
        choosenOperation.getItems().add(2,"Binary to Hexadecimal");
        choosenOperation.getItems().add(3,"Octal to Decimal");
        choosenOperation.getItems().add(4,"Octal to Binary");
        choosenOperation.getItems().add(5,"Octal to Hexadecimal");
        choosenOperation.getItems().add(6, "Hexadecimal to Decimal");
        choosenOperation.getItems().add(7," Hexadecimal to Binary ");
        choosenOperation.getItems().add(8,"Hexadecimal to Octal");
        choosenOperation.getItems().add(9,"Decimal to Binary");
        choosenOperation.getItems().add(10, "Decimal to Octal");
        choosenOperation.getItems().add(11,"Decimal to Hexadecimal");

    }

    public void convert () {
        switch (choosenOperation.getSelectionModel().getSelectedIndex()) {
            case 0:
                type=new Binary(theNumber.getText());
                theNumber.setText(type.getDecimalRepresentaion()+"");
                break;
            case 1 :
                type=new Binary(theNumber.getText());
                converter = new ConvertOctal();
                theNumber.setText(converter.convert(type).getValue() );
                break;
            case 2:
                type=new Binary(theNumber.getText());
                converter = new ConvertHexadecimal();
                theNumber.setText(converter.convert(type).getValue() );
                break;
            case 3:
                type=new Octal(theNumber.getText());
                theNumber.setText(type.getDecimalRepresentaion()+"");
                break;
            case 4:
                type=new Octal(theNumber.getText());
                converter = new ConvertBinary();
                theNumber.setText(converter.convert(type).getValue() );
                break;
            case 5:
                type=new Octal(theNumber.getText());
                converter = new ConvertHexadecimal();
                theNumber.setText(converter.convert(type).getValue() );
                break;

            case 6:
                type=new Hexadecimal(theNumber.getText());
                theNumber.setText(type.getDecimalRepresentaion()+"");
                break;
            case 7 :
                type=new Hexadecimal(theNumber.getText());
                converter = new ConvertBinary();
                theNumber.setText(converter.convert(type).getValue() );
                break;
            case 8:
                type=new Hexadecimal(theNumber.getText());
                converter = new ConvertOctal();
                theNumber.setText(converter.convert(type).getValue() );
                break;

            case 9:
                type = new Binary(Integer.parseInt(theNumber.getText()));
                theNumber.setText(type.getValue());
                break;
            case 10:
                type = new Octal(Integer.parseInt(theNumber.getText()));
                theNumber.setText(type.getValue());
                break;
            case 11:
                type = new Hexadecimal(Integer.parseInt(theNumber.getText()));
                theNumber.setText(type.getValue());
                break;





        }}
    public void returnMainView(){
        myScreen.setScreen("MainView");
    }
}

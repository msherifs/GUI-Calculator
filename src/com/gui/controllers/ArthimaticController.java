package com.gui.controllers;
import com.calculator.arthimatic.ArthimaticOperations;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
public class ArthimaticController implements ControlledScreen {

    @FXML
    private JFXTextField output;

    private double number1 = 0;
    private String operator = "";
    private boolean start = true;
    ScreensController myScreen;

    private ArthimaticOperations calculator = new ArthimaticOperations();

    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if (operator.isEmpty())
                return;

            output.setText(String.valueOf(calculator.calculate(number1, Double.parseDouble(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }

    @FXML
    public void returnMainView(){
        myScreen.setScreen("MainView");
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myScreen = screenPage;
    }
}

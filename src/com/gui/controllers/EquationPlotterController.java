package com.gui.controllers;

import com.calculator.equation.plotter.Axes;
import com.calculator.equation.plotter.Plot;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * Created by mohamedhisham on 12/29/16.
 */
public class EquationPlotterController implements ControlledScreen {
    @FXML
    AnchorPane plottingPane;
    ScreensController myScreen;
    @FXML
    JFXTextField a,b,c ;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myScreen = screenPage;
    }

    public void returnMainView(){
        myScreen.setScreen("MainView");
    }

    public void plot(){
        Axes axes = new Axes(
                1990, 1990,
                -50, 50, .5,
                -50, 50, .5
        );

        Plot plot = new Plot(
                x -> Double.parseDouble(a.getText()) * x*x + Double.parseDouble(b.getText()) *x + Double.parseDouble(c.getText()) ,
                -40, 40, 0.1,
                axes
        );
        plottingPane.setPrefHeight(2000);
        plottingPane.setPrefWidth(2000);
        plottingPane.getChildren().add(plot);
    }
}

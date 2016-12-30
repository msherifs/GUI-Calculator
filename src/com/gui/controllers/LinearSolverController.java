package com.gui.controllers;

import Jama.Matrix;
import com.calculator.equation.Coefficient;
import com.calculator.equation.Equation;
import com.calculator.equation.Solver.LinearSolver;
import com.jfoenix.controls.JFXTextField;
import com.sun.tools.javac.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mohamedsherif on 12/30/16.
 */
public class LinearSolverController implements ControlledScreen {
    ScreensController myScreen;
    @FXML
    JFXTextField aX, bX, cX, aY, bY, cY, aZ, bZ, cZ, aD, bD, cD;
    @FXML
    Label X, Y, Z;

    public void solve(){
        Coefficient [] s = new Coefficient[12];
        Equation [] eq = new Equation[3];
        ArrayList<Coefficient> a = new ArrayList<>();
        ArrayList<Coefficient> b = new ArrayList<>();
        ArrayList<Coefficient> c = new ArrayList<>();

        a.add(new Coefficient(Double.parseDouble(aX.getText()),1));
        a.add(new Coefficient(Double.parseDouble(aY.getText()),1));
        a.add(new Coefficient(Double.parseDouble(aZ.getText()),1));
        a.add(new Coefficient(Double.parseDouble(aD.getText()),0));
        eq[0] = new Equation(a);


        b.add(new Coefficient(Double.parseDouble(bX.getText()),1));
        b.add(new Coefficient(Double.parseDouble(bY.getText()),1));
        b.add(new Coefficient(Double.parseDouble(bZ.getText()),1));
        b.add(new Coefficient(Double.parseDouble(bD.getText()),0));
        eq[1] = new Equation(b);

        c.add(new Coefficient(Double.parseDouble(cX.getText()),1));
        c.add(new Coefficient(Double.parseDouble(cY.getText()),1));
        c.add(new Coefficient(Double.parseDouble(cZ.getText()),1));
        c.add(new Coefficient(Double.parseDouble(cD.getText()),0));
        eq[2] = new Equation(c);

        LinearSolver ls = new LinearSolver(eq);
        Matrix ans = ls.solve();
        X.setText(String.format("%2.3f", ans.get(0,0)));
        Y.setText(String.format("%2.3f", ans.get(1,0)));
        Z.setText(String.format("%2.3f", ans.get(2,0)));
    }

    public void returnMainView(){
        myScreen.setScreen("MainView");
    }
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myScreen = screenPage;
    }
}

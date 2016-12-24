package com.calculator.equation.Solver;

import com.calculator.equation.Coefficient;
import com.calculator.equation.Equation;
import Jama.Matrix;

/**
 * Created by mohamedsherif on 12/18/16.
 */
public class LinearSolver {

    private double [][] A = new double[3][3];
    private double [] Z = new double[3];

    public LinearSolver(Equation [] equation){
        int i = 0;
        int j = 0;
        for (Equation a : equation){
            A[i][0] =  a.getEquation().get(j++).getValue();
            A[i][1] =  a.getEquation().get(j++).getValue();
            A[i][2] =  a.getEquation().get(j++).getValue();
            Z[i] = a.getEquation().get(j).getValue();
            i++;
            j = 0;
        }
    }


    public double[] solve(){
        Matrix eqMatrix = new Matrix(A);
        Matrix anMatrix = new Matrix(Z,3);
        Matrix sol = anMatrix.solve(eqMatrix);
        return sol.getColumnPackedCopy();
    }
}

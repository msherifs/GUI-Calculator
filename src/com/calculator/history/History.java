package com.calculator.history;

import com.calculator.equation.Coefficient;
import com.calculator.equation.Equation;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class History {

    public static ArrayList<StepData> history = new ArrayList<>();

    //called when closing the app
    public static void write(String fileName) {
        try {

            File file = new File(fileName);
            PrintWriter printWriter = new PrintWriter(file);
            for (StepData s : history) {
                printWriter.println(s.toString());
            }

            printWriter.close();
        } catch (Exception e) {
        }


    }

    //called when opening the app
    public static void read(String fileName) {

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            while (line != null) {
                if (line.contains("ADD")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(Double.parseDouble(data.get(0)), Double.parseDouble(data.get(1)), Operation.ADD));
                }
                if (line.contains("SUB")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(Double.parseDouble(data.get(0)), Double.parseDouble(data.get(1)),Operation.SUB));

                }
                if (line.contains("MULTI")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(Double.parseDouble(data.get(0)), Double.parseDouble(data.get(1)),Operation.MULTI));

                }
                if (line.contains("DIV")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(Double.parseDouble(data.get(0)), Double.parseDouble(data.get(1)),Operation.DIV));

                }
                if (line.contains("SOLVE")) {
                    List<String> coefficientArray = Arrays.asList(line.split("_"));
                    ArrayList<Coefficient> ready = new ArrayList<Coefficient>();
                    for (String eq : coefficientArray) {
                        List<String> equationsCoeff = Arrays.asList(line.split(","));
                        ready.add(new Coefficient(Double.parseDouble(equationsCoeff.get(0)), Integer.parseInt(equationsCoeff.get(1))));
                    }
                    history.add(new StepData(new Equation(ready),Operation.SOLVE));
                }
                if (line.contains("PLOT")) {
                    List<String> coefficientArray = Arrays.asList(line.split("_"));
                    ArrayList<Coefficient> ready = new ArrayList<Coefficient>();
                    for (String eq : coefficientArray) {
                        List<String> equationsCoeff = Arrays.asList(line.split(","));
                        ready.add(new Coefficient(Double.parseDouble(equationsCoeff.get(0)), Integer.parseInt(equationsCoeff.get(1))));
                    }
                    history.add(new StepData(new Equation(ready),Operation.PLOT));
                }

                if (line.contains("SOLVEMANY")) {
                    List<String> coefficientArray = Arrays.asList(line.split("_"));
                    ArrayList<Coefficient> ready = new ArrayList<Coefficient>();
                    ArrayList<Equation> equations = new ArrayList<>();
                    for (String eq : coefficientArray) {
                        List<String> equationsCoeff = Arrays.asList(line.split(","));
                        ready.add(new Coefficient(Double.parseDouble(equationsCoeff.get(0)), Integer.parseInt(equationsCoeff.get(1))));
                        equations.add(new Equation(ready));
                    }
                    history.add(new StepData(equations,Operation.SOLVEMANY));


                }
                if (line.contains("TOHEX")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(Double.parseDouble(data.get(0)), Operation.TOHEX));

                }
                if (line.contains("TOBIN")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(Double.parseDouble(data.get(0)), Operation.TOBIN));

                }
                if (line.contains("TOOCTA")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(Double.parseDouble(data.get(0)), Operation.TOOCTA));

                }
                if (line.contains("FROMHEX")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(data.get(0), Operation.FROMHEX));

                }
                if (line.contains("FROMBIN")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(data.get(0), Operation.FROMBIN));

                }
                if (line.contains("FROMOCTA")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(data.get(0), Operation.FROMOCTA));

                }
                if (line.contains("FEETTOM")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(data.get(0), Operation.FEETTOM));

                }
                if (line.contains("KGTOG")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(data.get(0), Operation.KGTOG));

                }
                if (line.contains("KMTOM")) {
                    List<String> data = Arrays.asList(line.split(","));
                    history.add(new StepData(data.get(0), Operation.KMTOM));

                }








                line = br.readLine();
            }

        } catch (Exception e) {
        }


    }


}
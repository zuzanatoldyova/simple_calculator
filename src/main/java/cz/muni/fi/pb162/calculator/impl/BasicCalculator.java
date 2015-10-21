package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import cz.muni.fi.pb162.calculator.Result;

/**
 *
 * @author Zuzana Toldyova <323119@mail.muni.cz>
 */
public class BasicCalculator implements Calculator {

    public Result eval(String input) {
        Result result;
        char a = input.charAt(1);
        char b = input.charAt(2);
        int doubleA = (int) a;
        int doubleB = (int) b;
        switch (String.valueOf(input.charAt(0))) {
            case "+":
                result = new CalculationResult(doubleA + doubleB);
                break;
            case "-":
                result = new CalculationResult(doubleA - doubleB);
                break;
            case "*":
                result = new CalculationResult(doubleA * doubleB);
                break;
            case "/":
                result = new CalculationResult(doubleA / doubleB);
                break;
            case "!":
                fac(doubleA);
        }
    }

    @Override
    public Result sum(double x, double y) {
        Result result = new CalculationResult(x + y);
        return result;
    }

    @Override
    public Result sub(double x, double y) {
        Result result = new CalculationResult(x - y);
        return result;
    }

    @Override
    public Result mul(double x, double y) {
        Result result = new CalculationResult(x * y);
        return result;
    }

    @Override
    public Result div(double x, double y) {
        Result result = new CalculationResult(x / y);
        return result;
    }

    @Override
    public Result fac(int x) {
        double a;
        if (x != 0) {
            a = x * fac(x - 1).getNumericValue();
        }
        Result result = new CalculationResult(a);
        return result;
    }
}

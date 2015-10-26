package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import cz.muni.fi.pb162.calculator.Result;

/**
 *
 * @author Zuzana Toldyova <323119@mail.muni.cz>
 */
public class BasicCalculator implements Calculator {

    @Override
    public Result eval(String input) {
        Result result;
        String[] split = input.split("\\s+");
        if (split.length < 2) {
            return result = new CalculationResult(UNKNOWN_OPERATION_ERROR_MSG);
        }        
        String a = split[1];
        double doubleA = Double.parseDouble(a);
        if (split.length == 3) {
            String b = split[2];
            double doubleB = Double.parseDouble(b);
            switch (String.valueOf(split[0])) {
                case SUM_CMD:
                    return sum(doubleA, doubleB);
                case SUB_CMD:
                    return sub(doubleA, doubleB);
                case MUL_CMD:
                    return mul(doubleA, doubleB);
                case DIV_CMD:
                    return div(doubleA, doubleB);
                default:
                    return result = new CalculationResult(UNKNOWN_OPERATION_ERROR_MSG);

            }
        }
        switch (String.valueOf(split[0])) {

            case FAC_CMD:
                return fac((int) doubleA);
            default:
                return result = new CalculationResult(UNKNOWN_OPERATION_ERROR_MSG);
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
        Result result;
        if (y == 0) {
            return result = new CalculationResult(COMPUTATION_ERROR_MSG);
        }
        return result = new CalculationResult(x / y);
    }

    @Override
    public Result fac(int x) {
        Result result;
        if (x < 0) {
        return result = new CalculationResult(COMPUTATION_ERROR_MSG);
        }       
        double a = 1;
        for (int i = x; i > 0; --i) {
             a *= i;
           
        }
        return result = new CalculationResult(a);
        
    }
}

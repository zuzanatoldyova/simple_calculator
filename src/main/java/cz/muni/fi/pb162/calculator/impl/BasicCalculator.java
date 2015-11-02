package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import cz.muni.fi.pb162.calculator.Result;
import java.util.Arrays;

/**
 *
 * @author Zuzana Toldyova <323119@mail.muni.cz>
 */
public class BasicCalculator implements Calculator {

    @Override
    public Result eval(String input) {
        String[] split = input.trim().split("\\s+");
        String[] operators = {SUM_CMD, SUB_CMD, MUL_CMD, DIV_CMD, FAC_CMD};
        if (split.length > 0 && !Arrays.asList(operators).contains(split[0])) {
            return new CalculationResult(UNKNOWN_OPERATION_ERROR_MSG);
        }
        if (split.length == 2) {
            double doubleA = Double.parseDouble(split[1]);
            switch (split[0]) {
                case FAC_CMD:
                    return fac((int) doubleA);
                default:
                    return new CalculationResult(WRONG_ARGUMENTS_ERROR_MSG);
            }
        }
        if (split.length == 3) {
            double doubleA = Double.parseDouble(split[1]);
            double doubleB = Double.parseDouble(split[2]);
            switch (split[0]) {
                case SUM_CMD:
                    return sum(doubleA, doubleB);
                case SUB_CMD:
                    return sub(doubleA, doubleB);
                case MUL_CMD:
                    return mul(doubleA, doubleB);
                case DIV_CMD:
                    return div(doubleA, doubleB);
                default:
                    return new CalculationResult(WRONG_ARGUMENTS_ERROR_MSG);
            }
        }
        return new CalculationResult(WRONG_ARGUMENTS_ERROR_MSG);
    }

    @Override
    public Result sum(double x, double y) {
        return new CalculationResult(x + y);
    }

    @Override
    public Result sub(double x, double y) {
        return new CalculationResult(x - y);
    }

    @Override
    public Result mul(double x, double y) {
        return new CalculationResult(x * y);
    }

    @Override
    public Result div(double x, double y) {
        if (y == 0){
            return new CalculationResult(COMPUTATION_ERROR_MSG);
        }
        return  new CalculationResult(x / y);
    }

    @Override
    public Result fac(int x) {
        if (x < 0) {
            return  new CalculationResult(COMPUTATION_ERROR_MSG);
        }
        double a = 1;
        for (int i = x; i > 0; --i) {
            a *= i;
        }
        return  new CalculationResult(a);
    }
}

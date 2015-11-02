package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Result;
import cz.muni.fi.pb162.calculator.Calculator;

/**
 *
 * @author Zuzana Toldyova <323119@mail.muni.cz>
 */
public class CalculationResult implements Result {

    private final double numResult;
    private String strResult;

    CalculationResult(double numResult) {
        this.numResult = numResult;
    }

    CalculationResult(String strResult) {
        this.strResult = strResult;
        this.numResult = Double.NaN;
    }

    @Override
    public boolean isSuccess() {
        if ((strResult != null) && (strResult.equals(Calculator.COMPUTATION_ERROR_MSG)
                || strResult.equals(Calculator.UNKNOWN_OPERATION_ERROR_MSG)
                || strResult.equals(Calculator.WRONG_ARGUMENTS_ERROR_MSG))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isAlphanumeric() {
        return strResult != null;
    }

    @Override
    public boolean isNumeric() {
        return !Double.isNaN(numResult);
    }

    @Override
    public double getNumericValue() {
        return numResult;
    }

    @Override
    public String getAlphanumericValue() {
        return strResult;
    }

}

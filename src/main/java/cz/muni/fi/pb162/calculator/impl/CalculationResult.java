package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Result;

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
        if (strResult != null) {
            if (strResult.equals("COMPUTATION ERROR") || strResult.equals("UNKNOWN OPERATION")
                    || strResult.equals("WRONG ARGUMENTS")) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isAlphanumeric() {
        if (strResult != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNumeric() {
        if (Double.isNaN(numResult)) {
            return false;
        }
        return true;
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

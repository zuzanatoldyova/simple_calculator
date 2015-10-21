package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Result;

/**
 *
 * @author Zuzana Toldyova <323119@mail.muni.cz>
 */
public class CalculationResult implements Result {

    private double numResult;
    private String strResult;
    
    CalculationResult(double numResult){
    this.numResult = numResult;
    }
    
    CalculationResult(double numResult, String strResult){
    this.strResult = strResult;
    }

    public boolean isSuccess() {
        if (numResult != 0) {
            return true;
        }
        return false;
    }
    
    public boolean isAlphanumeric(){
    if (isSuccess() && strResult != null)
        return true;
    return false;
    }
    
    public boolean isNumeric();
    
    public double getNumericValue();
    
    public String getAlphanumericValue();
}

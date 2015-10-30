package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Result;

/**
 *
 * @author Zuzana Toldyova <323119@mail.muni.cz>
 */
public class AdvancedCalculator extends BasicCalculator implements ConvertingCalculator {

    @Override
    public Result toDec(int base, String number) {
        Result result;
        double a = 0;
        int length = number.length();
        if (length == 0) {
            return result = new CalculationResult(WRONG_ARGUMENTS_ERROR_MSG);
        }
        if (base < 2 || base > 16) {
            return result = new CalculationResult(COMPUTATION_ERROR_MSG);
        }

        for (int i = 0; i < length; i++) {
            if (DIGITS.indexOf(number.charAt(i)) >= base || DIGITS.indexOf(number.charAt(i)) == -1) {
                return result = new CalculationResult(COMPUTATION_ERROR_MSG);
            }
            a += DIGITS.indexOf(number.charAt(i)) * Math.pow(base, (length - 1 - i));
        }
        return result = new CalculationResult(a);
    }

    @Override
    public Result fromDec(int base, int number) {
        Result result;
        if (base < 2 || base > 16) {
            return result = new CalculationResult(COMPUTATION_ERROR_MSG);
        }
        String computation = "";

        for (int i = number; i > 0; i = i / base) {
            int a = i % base;
            computation = DIGITS.substring(a, a + 1) + computation;
        }
        return result = new CalculationResult(computation);
    }   

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
                case TO_DEC_CMD:
                    return toDec((int) doubleA, b);
                case FROM_DEC_CMD:
                    return fromDec((int) doubleA, (int) doubleB);
                default:
                    return super.eval(input);
            }
        }
        return super.eval(input);
    }
}

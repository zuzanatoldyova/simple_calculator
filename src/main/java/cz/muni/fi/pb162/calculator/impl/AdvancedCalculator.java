package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Result;
import java.util.Arrays;

/**
 *
 * @author Zuzana Toldyova <323119@mail.muni.cz>
 */
public class AdvancedCalculator extends BasicCalculator implements ConvertingCalculator {

    @Override
    public Result toDec(int base, String number) {
        double a = 0;
        int length = number.length();
        if (length == 0) {
            return new CalculationResult(WRONG_ARGUMENTS_ERROR_MSG);
        }
        if (base < 2 || base > 16) {
            return new CalculationResult(COMPUTATION_ERROR_MSG);
        }
        for (int i = 0; i < length; i++) {
            if (DIGITS.indexOf(number.charAt(i)) >= base || DIGITS.indexOf(number.charAt(i)) == -1) {
                return new CalculationResult(COMPUTATION_ERROR_MSG);
            }
            a += DIGITS.indexOf(number.charAt(i)) * Math.pow(base, (length - 1 - i));
        }
        return new CalculationResult(a);
    }

    @Override
    public Result fromDec(int base, int number) {
        if (base < 2 || base > 16) {
            return new CalculationResult(COMPUTATION_ERROR_MSG);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = number; i > 0; i = i / base) {
            int a = i % base;
            sb.append(DIGITS.substring(a, a + 1));
        }
        return new CalculationResult(sb.reverse().toString());
    }

    @Override
    public Result eval(String input) {
        String[] split = input.trim().split("\\s+");
        String[] operators = {TO_DEC_CMD, FROM_DEC_CMD};
        if (split.length > 0 && !Arrays.asList(operators).contains(split[0])) {
            return super.eval(input);
        }
        int intA = Integer.parseInt(split[1]);
        if (split.length == 3) {
            String b = split[2];
            if (split[0].equals(TO_DEC_CMD)) {
                return toDec(intA, b);
            }
            if (split[0].equals(FROM_DEC_CMD)) {
                return fromDec(intA, Integer.parseInt(b));
            }
        }
        return new CalculationResult(WRONG_ARGUMENTS_ERROR_MSG);
    }
}

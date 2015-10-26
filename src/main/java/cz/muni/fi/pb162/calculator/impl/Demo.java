package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import cz.muni.fi.pb162.calculator.Result;

/**
 *
 * @author Zuzana Toldyova <323119@mail.muni.cz>
 */
public class Demo {

    /**
     * blidja
     *
     * @param args jjoiu
     */

    public static void main(String[] args) {
        Calculator test = new BasicCalculator();
        Result a = test.eval("! 3");
        System.out.println(a);
        System.out.println(a.isSuccess());
        System.out.println(1/2);
        System.out.println("vaj");
        ConvertingCalculator test1 = new AdvancedCalculator();
        Result b = test1.fromDec(17, 10);
        System.out.println(b.isSuccess());
        System.out.println(b);
        System.out.println(b.isNumeric());
        
    }

}

package cz.muni.fi.pb162.calculator.impl;

import cz.muni.fi.pb162.calculator.Calculator;
import cz.muni.fi.pb162.calculator.Result;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jcechace
 */
public class BasicCalculatorTest extends CalculatorTestBase {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Override
    protected Calculator getCalc() {
        return new BasicCalculator();
    }

    @Test
    public void multiplication() {
        assertNumericResult("4*2", 8, getCalc().mul(4, 2));
    }

    @Test
    public void division() {
        assertNumericResult("4/2", 2, getCalc().div(4, 2));
    }

    @Test
    public void divisionByZero() {
        assertError("Division by zero should fail", getCalc().div(4, 0));
    }

    @Test
    public void factorial() {
        assertNumericResult("4!", 24, getCalc().fac(4));
    }

    @Test
    public void factorialOfZero() {
        assertNumericResult("0!", 1, getCalc().fac(0));
    }

    @Test
    public void factorialOfNegativeNumber() {
        assertError("(-7)!", getCalc().fac(-7));
    }

    @Test
    public void sum() {
        assertNumericResult("4+2", 6, getCalc().sum(4, 2));
    }

    @Test
    public void subtraction() {
        assertNumericResult("4-2", 2, getCalc().sub(4, 2));
    }

    /**
     * Test of eval method, of class BasicCalculator.
     */
    @Test
    public void testEval() {
        System.out.println("eval");
        String input = "";
        BasicCalculator instance = new BasicCalculator();
        Result expResult = null;
        Result result = instance.eval(input);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sum method, of class BasicCalculator.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        double x = 0.0;
        double y = 0.0;
        BasicCalculator instance = new BasicCalculator();
        Result expResult = null;
        Result result = instance.sum(x, y);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class BasicCalculator.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        double x = 0.0;
        double y = 0.0;
        BasicCalculator instance = new BasicCalculator();
        Result expResult = null;
        Result result = instance.sub(x, y);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

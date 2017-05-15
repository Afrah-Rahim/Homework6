import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class PolyTest.
 *
 * @author  (Derrick Persaud)
 * @version (4/24/2016)
 */
public class PolyTest
{
    private Polynomial equation;

    /**
     * Default constructor for test class Polynomial
     */
    public PolyTest()
    {
        //System.out.println("JUnit Framework calls Constructor of test class before executing test methods");
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        equation = new Polynomial();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
        equation = null;
    }

    //Test toString method
    @Test
    public void testToString()
    {
        //Tests toString method for Polynomials

        //Test 1 - only positive Polynomials
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms1 = new ArrayList<Term>();
        terms1.add(new Term(1,1)); //1x^1
        terms1.add(new Term(2,2)); //2x^2
        terms1.add(new Term(3,3)); //3x^3
        terms1.add(new Term(4,4)); //4x^4
        Polynomial equation1 = new Polynomial(terms1);

        String actual1 = "Polynomial 1: " + equation1.toString();
        String expected1 = "Polynomial 1: 4x^4+3x^3+2x^2+1x^1";

        assertTrue("Error in testToString", actual1.equals(expected1));

        //Test 2 - only negative Polynomials
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms2 = new ArrayList<Term>();
        terms2.add(new Term(-1,1)); //-1x^1
        terms2.add(new Term(-7,6)); //-7x^6
        terms2.add(new Term(-5,3)); //-5x^3
        terms2.add(new Term(-1,4)); //-1x^4
        Polynomial equation2 = new Polynomial(terms2);
    
        String actual2 = "Polynomial 2: " + equation2.toString();
        String expected2 = "Polynomial 2: -7x^6-1x^4-5x^3-1x^1";

        assertTrue("Error in testToString", actual2.equals(expected2));

        //Test 3 - mixed postives and negatives
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms3 = new ArrayList<Term>();
        terms3.add(new Term(-1,1)); //-1x^1
        terms3.add(new Term(7,6)); //7x^6
        terms3.add(new Term(5,3)); //5x^3
        terms3.add(new Term(-1,4)); //-1x^4
        Polynomial equation3 = new Polynomial(terms3);

        String actual3 = "Polynomial 3: " + equation3.toString();
        String expected3 = "Polynomial 3: 7x^6-1x^4+5x^3-1x^1";

        assertTrue("Error in testToString", actual3.equals(expected3));

        //Test 4 - using negative degrees & positives
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms4 = new ArrayList<Term>();
        terms4.add(new Term(-1,-1)); //-1x^-1
        terms4.add(new Term(7,6)); //7x^6
        terms4.add(new Term(5,-3)); //5x^-3
        terms4.add(new Term(-1,4)); //-1x^4
        Polynomial equation4 = new Polynomial(terms4);
        
        String actual4 = "Polynomial 4: " + equation4.toString();
        String expected4 = "Polynomial 4: 7x^6-1x^4-1x^-1+5x^-3";

        assertTrue("Error in testToString", actual4.equals(expected4));

        //Test 5 - only negative degrees
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms5 = new ArrayList<Term>(); 
        terms5.add(new Term(-1,-1)); //-1x^-1
        terms5.add(new Term(7,-6)); //7x^-6
        terms5.add(new Term(5,-3)); //5x^-3
        terms5.add(new Term(-1,-4)); //-1x^-4
        Polynomial equation5 = new Polynomial(terms5);

        String actual5 = "Polynomial 5: " + equation5.toString();
        String expected5 = "Polynomial 5: -1x^-1+5x^-3-1x^-4+7x^-6";

        assertTrue("Error in testToString", actual5.equals(expected5));

        //Test 6 - all Coefficients of 0 (should not be printed)
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms6 = new ArrayList<Term>(); 
        terms6.add(new Term(0,-1)); //0x^-1
        terms6.add(new Term(0,-6)); //0x^-6
        terms6.add(new Term(0,-3)); //0x^-3
        terms6.add(new Term(0,-4)); //0x^-4
        Polynomial equation6 = new Polynomial(terms6);

        String actual6 = "Polynomial 6: " + equation6.toString();
        String expected6 = "Polynomial 6: "; //Coefficients of 0 ignored, in this case all had a coefficient of 0

        assertTrue("Error in testToString", actual6.equals(expected6));

        //Test 7 - few Coefficients of 0 (should not print those)
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms7 = new ArrayList<Term>();
        terms7.add(new Term(0,-1)); //0x^-1
        terms7.add(new Term(3,-6)); //3x^-6
        terms7.add(new Term(0,-3)); //0x^-3
        terms7.add(new Term(2,-4)); //2x^-4
        Polynomial equation7 = new Polynomial(terms7);

        String actual7 = "Polynomial 7: " + equation7.toString();
        String expected7 = "Polynomial 7: +2x^-4+3x^-6"; //Coefficients of 0 ignored

        assertTrue("Error in testToString", actual7.equals(expected7));

        //Test 8 - including a power of 0
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms8 = new ArrayList<Term>(); 
        terms8.add(new Term(1,2)); //1x^2
        terms8.add(new Term(3,1)); //3x^1
        terms8.add(new Term(2,3)); //2x^3
        terms8.add(new Term(3,0)); //3x^0

        Polynomial equation8 = new Polynomial(terms8);
        // 0 ^ 0 will just result to nothing because coefficient of 0 so it wouldn't be processed
        //anything to the power of 0 = 1 therefore four constants added that are to the power of 0 = 4 

        String actual8 = "Polynomial 8: " + equation8.toString();
        String expected8 = "Polynomial 8: 2x^3+1x^2+3x^1+3";   
        // +3 because 3x^0 = 3(1) since x^0 = 1 and 3 x 1 = 3

        assertTrue("Error in testToString", actual8.equals(expected8));
    }

    //Test Evalue method
    @Test
    public void testEvaluate()
    { 
        //Test 1 - if x was 1 
        //adds coefficients to the polynomial (coefficient,power)  
        ArrayList<Term> terms1 = new ArrayList<Term>();
        terms1.add(new Term(1,1)); //1x^1
        terms1.add(new Term(2,2)); //2x^2
        terms1.add(new Term(3,3)); //3x^3
        terms1.add(new Term(4,4)); //4x^4
        Polynomial equation1 = new Polynomial(terms1);

        String actual1 = "Evaluation result when x = 1: " + equation1.evaluate(1);
        String expected1 = "Evaluation result when x = 1: 10.0"; 
        //1 to all powers is 1 therefore 1 + 2 + 3 + 4 = 10

        //Test 2 - if x was 0
        String actual2 = "Evaluation result when x = 0: " + equation1.evaluate(0);
        String expected2 = "Evaluation result when x = 0: 0.0";
        //all variables become 0 and added will still be 0 

        assertTrue("Error in testEvaluate", actual2.equals(expected2));

        //Test 3 - if x was 3 (positive but > 1 )
        String actual3 = "Evaluation result when x = 3: " + equation1.evaluate(3);
        String expected3 = "Evaluation result when x = 3: 426.0";

        assertTrue("Error in testEvaluate", actual3.equals(expected3));

        //Test 4 - if x was -2 (negative)
        String actual4 = "Evaluation result when x = -2: " + equation1.evaluate(-2);
        String expected4 = "Evaluation result when x = -2: 46.0";
        //Wherever there is a ^2 or ^4 it will result in a positive number 4(2)^4 being the biggest
        //and positive number made the result positive

        assertTrue("Error in testEvaluate", actual4.equals(expected4));

        //Test 5 - using negative degrees & positives
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms2 = new ArrayList<Term>();
        terms2.add(new Term(-1,-1)); //-1x^-1
        terms2.add(new Term(7,6)); //7x^6
        terms2.add(new Term(5,-3)); //5x^-3
        terms2.add(new Term(-1,4)); //-1x^4
        Polynomial equation2 = new Polynomial(terms2);

        String actual5 = "Evaluation result when x = -4: " + equation2.evaluate(-4);
        String expected5 = "Evaluation result when x = -4: 28416.171875";

        assertTrue("Error in testEvaluate", actual5.equals(expected5));

        // Positive
        String actual6 = "Evaluation result when x = 4: " + equation2.evaluate(4);
        String expected6 = "Evaluation result when x = 4: 28415.828125";

        assertTrue("Error in testEvaluate", actual6.equals(expected6));

        //And of course if coefficients were all 0's it would result to 0

    }

    //Test add method
    @Test
    public void testAdd()
    {
        //Test 1, add two of the same polynomials
        ArrayList<Term> terms1 = new ArrayList<Term>();
        terms1.add(new Term(1,1)); //1x^1
        terms1.add(new Term(2,2)); //2x^2
        terms1.add(new Term(3,3)); //3x^3
        terms1.add(new Term(4,4)); //4x^4
        Polynomial equation1 = new Polynomial(terms1);

        String actual1 = "New added polynomial: " + equation1.add(equation1);
        String expected1 = "New added polynomial: 8x^4+6x^3+4x^2+2x^1";

        assertTrue("Error in testAdd", actual1.equals(expected1));

        //Test 2, add two polynomials to negative degrees
        ArrayList<Term> terms2 = new ArrayList<Term>();
        terms2.add(new Term(1,-1)); //1x^-1
        terms2.add(new Term(2,-2)); //2x^-2
        terms2.add(new Term(3,-3)); //3x^-3
        terms2.add(new Term(4,-4)); //4x^-4
        Polynomial equation2 = new Polynomial(terms2);

        String actual2 = "New added polynomial: " + equation2.add(equation2);
        String expected2 = "New added polynomial: 2x^-1+4x^-2+6x^-3+8x^-4";

        assertTrue("Error in testAdd", actual2.equals(expected2));

        //Test 3 - add two polynomials, a negative and a postive in terms of powers
        ArrayList<Term> terms3 = new ArrayList<Term>();
        terms3.add(new Term(1,-1)); //1x^-1
        terms3.add(new Term(2,-2)); //2x^-2
        terms3.add(new Term(3,-3)); //3x^-3
        terms3.add(new Term(4,-4)); //4x^-4
        Polynomial equation3 = new Polynomial(terms3);

        ArrayList<Term> terms4 = new ArrayList<Term>();
        terms4.add(new Term(1,1)); //1x^1
        terms4.add(new Term(2,2)); //2x^2
        terms4.add(new Term(3,3)); //3x^3
        terms4.add(new Term(4,4)); //4x^4
        Polynomial equation4 = new Polynomial(terms4);

        String actual3 = "New added polynomial: " + equation3.add(equation4);
        String expected3 = "New added polynomial: 4x^4+3x^3+2x^2+1x^1+1x^-1+2x^-2+3x^-3+4x^-4";

        assertTrue("Error in testAdd", actual3.equals(expected3));

        //Test 4 - add two polynomials, different and similar powers
        ArrayList<Term> terms5 = new ArrayList<Term>();
        terms5.add(new Term(2,1)); //2x^1
        terms5.add(new Term(2,2)); //2x^2
        terms5.add(new Term(5,3)); //5x^3
        terms5.add(new Term(4,4)); //4x^4
        Polynomial equation5 = new Polynomial(terms5);

        ArrayList<Term> terms6 = new ArrayList<Term>();
        terms6.add(new Term(3,4)); //3x^1
        terms6.add(new Term(2,2)); //2x^2
        terms6.add(new Term(1,3)); //1x^3
        terms6.add(new Term(9,1)); //9x^1
        Polynomial equation6 = new Polynomial(terms6);

        String actual4 = "New added polynomial: " + equation5.add(equation6);
        String expected4 = "New added polynomial: 7x^4+6x^3+4x^2+11x^1";

        assertTrue("Error in testAdd", actual4.equals(expected4));

        //Test 5 - add two polynomials all coefficients negative
        ArrayList<Term> terms7 = new ArrayList<Term>();
        terms7.add(new Term(-1,1)); //-1x^1
        terms7.add(new Term(-2,2)); //-2x^2
        terms7.add(new Term(-3,3)); //-3x^3
        terms7.add(new Term(-4,4)); //-4x^4
        Polynomial equation7 = new Polynomial(terms7);

        ArrayList<Term> terms8 = new ArrayList<Term>();
        terms8.add(new Term(-4,1)); //-4x^1
        terms8.add(new Term(-5,2)); //-5x^2
        terms8.add(new Term(-7,3)); //-7x^3
        terms8.add(new Term(-6,4)); //-6x^4
        Polynomial equation8 = new Polynomial(terms8);

        String actual5 = "New added polynomial: " + equation7.add(equation8);
        String expected5 = "New added polynomial: -10x^4-10x^3-7x^2-5x^1";
        
        assertTrue("Error in testAdd", actual5.equals(expected5));
    }

    //Test derivative method 
    @Test
    public void testDerivative()
    {
        //Tests toString method for Polynomials

        //Test 1 - only positive Polynomials
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms1 = new ArrayList<Term>();
        terms1.add(new Term(1,1)); //1x^1
        terms1.add(new Term(2,2)); //2x^2
        terms1.add(new Term(3,3)); //3x^3
        terms1.add(new Term(4,4)); //4x^4
        Polynomial equation1 = new Polynomial(terms1);

        String actual1 = "Polynomial 1 derivative: " + equation1.getDerivative();
        String expected1 = "Polynomial 1 derivative: 16x^3+9x^2+4x^1+1";

        assertTrue("Error in testDerivative", actual1.equals(expected1));

        //Test 2 - only negative Polynomials
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms2 = new ArrayList<Term>();
        terms2.add(new Term(-1,1)); //-1x^1
        terms2.add(new Term(-7,6)); //-7x^6
        terms2.add(new Term(-5,3)); //-5x^3
        terms2.add(new Term(-1,4)); //-1x^4
        Polynomial equation2 = new Polynomial(terms2);

        String actual2 = "Polynomial 2 derivative: " + equation2.getDerivative();
        String expected2 = "Polynomial 2 derivative: -42x^5-4x^3-15x^2-1";


        assertTrue("Error in testDerivative", actual2.equals(expected2));

        //Test 3 - mixed postives and negatives
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms3 = new ArrayList<Term>();
        terms3.add(new Term(-1,1)); //-1x^1
        terms3.add(new Term(7,6)); //7x^6
        terms3.add(new Term(5,3)); //5x^3
        terms3.add(new Term(-1,4)); //-1x^4
        Polynomial equation3 = new Polynomial(terms3);
        
        String actual3 = "Polynomial 3 derivative: " + equation3.getDerivative();
        String expected3 = "Polynomial 3 derivative: 42x^5-4x^3+15x^2-1";

        assertTrue("Error in testToString", actual3.equals(expected3));

        //Test 4 - using negative degrees & positives
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms4 = new ArrayList<Term>();
        terms4.add(new Term(-1,-1)); //-1x^-1
        terms4.add(new Term(7,6)); //7x^6
        terms4.add(new Term(5,-3)); //5x^-3
        terms4.add(new Term(-1,4)); //-1x^4
        Polynomial equation4 = new Polynomial(terms4);

        String actual4 = "Polynomial 4 derivative: " + equation4.getDerivative();
        String expected4 = "Polynomial 4 derivative: 42x^5-4x^3+1x^-2-15x^-4";

        assertTrue("Error in testDerivative", actual4.equals(expected4));

        //Test 5 - only negative degrees
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms5 = new ArrayList<Term>(); 
        terms5.add(new Term(-1,-1)); //-1x^-1
        terms5.add(new Term(7,-6)); //7x^-6
        terms5.add(new Term(5,-3)); //5x^-3
        terms5.add(new Term(-1,-4)); //-1x^-4
        Polynomial equation5 = new Polynomial(terms5);

        String actual5 = "Polynomial 5 derivative: " + equation5.getDerivative();
        String expected5 = "Polynomial 5 derivative: 1x^-2-15x^-4+4x^-5-42x^-7";

        assertTrue("Error in testDerivative", actual5.equals(expected5));

        //Test 6 - all Coefficients of 0 (should not be printed)
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms6 = new ArrayList<Term>(); 
        terms6.add(new Term(0,-1)); //0x^-1
        terms6.add(new Term(0,-6)); //0x^-6
        terms6.add(new Term(0,-3)); //0x^-3
        terms6.add(new Term(0,-4)); //0x^-4
        Polynomial equation6 = new Polynomial(terms6);

        String actual6 = "Polynomial 6 derivative: " + equation6.getDerivative();
        String expected6 = "Polynomial 6 derivative: "; //Coefficients of 0 ignored, in this case all had a coefficient of 0

        assertTrue("Error in testDerivative", actual6.equals(expected6));

        //Test 7 - few Coefficients of 0 (should not print those)
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms7 = new ArrayList<Term>();
        terms7.add(new Term(0,-1)); //0x^-1
        terms7.add(new Term(3,-6)); //2x^-6
        terms7.add(new Term(0,-3)); //0x^-3
        terms7.add(new Term(2,-4)); //3x^-4
        Polynomial equation7 = new Polynomial(terms7);

        String actual7 = "Polynomial 7 derivative: " + equation7.getDerivative();
        String expected7 = "Polynomial 7 derivative: -8x^-5-18x^-7"; //Coefficients of 0 ignored

        assertTrue("Error in testDerivative", actual7.equals(expected7));

        //Test 8 - including a power of 0
        //adds coefficients to the polynomial (coefficient,power)
        ArrayList<Term> terms8 = new ArrayList<Term>(); 
        terms8.add(new Term(1,2)); //1x^2
        terms8.add(new Term(3,1)); //3x^1
        terms8.add(new Term(2,3)); //2x^3
        terms8.add(new Term(3,0)); //3x^0

        Polynomial equation8 = new Polynomial(terms8);
        // 0 ^ 0 will just result to nothing because coefficient of 0 so it wouldn't be processed
        //anything to the power of 0 = 1 therefore four constants added that are to the power of 0 = 4 

        String actual8 = "Polynomial 8 derivative: " + equation8.getDerivative();
        String expected8 = "Polynomial 8 derivative: 6x^2+2x^1+3";   
        // +3 because 3x^0 = 3(1) since x^0 = 1 and 3 x 1 = 3

        assertTrue("Error in testDerivative", actual8.equals(expected8));

    }
}

/**
 * Polynomial: stores polynomial terms that DON'T have zero coefficients
 *                                          (only non-zero coefficients)
 *             Prints a string displaying the polynomial
 *             Adds polynomials
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator; //Used with collections to sort 
import java.util.ListIterator;

public class Polynomial
{
    //Declare private variables
    private ArrayList<Term> polynomial;

    /**
     * Constructor: initializes all attributes the Polynomial
     */
    public Polynomial()
    {
        polynomial = new ArrayList<Term>();
    }// end constructor

    /**
     * Constructor: Creates polynomial from list of coefficients 
     *
     * @param       coefficient - Coefficient of the polynomial
     *                            the index of the coefficient represents the power of that 
     * @return      new polynomial
     */

    public Polynomial(int[] coefficient)
    {
        this.polynomial = new ArrayList<Term>();
        for (int i = 0; i < coefficient.length; i++)
        {
            polynomial.add(new Term(coefficient[i], i));
        }
        this.sort();
        this.simplify();
    }

    /**
     * Constructor: Creates polynomial from list of terms
     *
     * @param       terms - list of terms
     *                            
     * @return      new polynomial
     */

    public Polynomial(ArrayList<Term> terms)
    {
        this.polynomial = new ArrayList<Term>();
        this.polynomial.addAll(terms);
        this.sort();
        this.simplify();
    }

    /**
     * add:             adds polynomials and returns the new polynomial
     * Precondition:    the Polynomial object is valid
     *
     * @param           Polynomial other, polynomial being added to the current polynomial
     * @return          this, new polynomial (sum of the two polynomials) 
     */
    public Polynomial add(Polynomial other)
    {
        polynomial.addAll(other.polynomial);
        this.sort();
        this.simplify();
        return this;
    } // end add

    /**
     *Create Polynomial by adding the two given polynomials
     *
     *@param p1 - polynomial to add
     *@param p2 - polynomial to add
     *@return new Polynomial
     */
    public static Polynomial add(Polynomial p1, Polynomial p2){
        return new Polynomial().add(p1).add(p2);
    }

    /**
     *Sort Polynomial.
     */
    private void sort(){
        Collections.sort(polynomial, new Comparator<Term>(){
                public int compare(Term t1, Term t2){
                    if(t1.degree > t2.degree)
                        return -1;
                    else if (t1.degree < t2.degree)
                        return 1;
                    else
                        return 0;	
                }
            });
    }

    /**
     *Simplify Polynomial.
     */
    private void simplify(){
        ListIterator<Term> it = polynomial.listIterator();
        while(it.hasNext()){
            Term t1 = it.next();
            Term t2 = null;
            if(it.hasNext()){
                t2 = it.next();
                if(t1.compareTo(t2) == 0){
                    Term newTerm = Term.add(t1,t2);
                    it.remove();
                    it.previous();
                    it.remove();
                    it.add(newTerm);
                    it.previous();
                }
                else
                    it.previous();
            }
        }
    }

    /**
     * 
     * 
     */
    public double evaluate(int point)
    {
        double val = 0;
        for (Term t: polynomial)
        {
            val += t.coefficient *Math.pow(point, t.degree);
        }
        return val;
    }

    public void add(Term t) {
        for (int i = 0; i < polynomial.size(); i++) {
            if (polynomial.get(i).degree == t.degree) {
                polynomial.get(i).coefficient += t.coefficient;
                return;
            }
        }
        polynomial.add(t);
        Collections.sort(polynomial);
    }

    public Polynomial getDerivative()
    {
        //         Polynomial p = new Polynomial();
        //         for(Term t : polynomial)
        //         {
        //             if(t.degree != 0)
        //             {
        //                 p.add(new Term(t.coefficient*t.degree, t.degree -1));
        //             }
        //         }
        //         Collections.sort(polynomial);
        //         return p;
        ArrayList<Term> derivPoly = new ArrayList<Term>();
        for(Term t : polynomial)
        {
            if(t.degree != 0)
            {
                derivPoly.add(new Term(t.coefficient*t.degree, t.degree -1));
            }
        }
        Collections.sort(derivPoly);
        Polynomial derived = new Polynomial(derivPoly);
        return derived;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        int polysize = polynomial.size();
        for (int i = 0; i < polysize; i++)
        {
            Term t = polynomial.get(i);
            if((i < polysize && t.coefficient!=0 & t.degree!=0 && i == 0))
            {
                builder.append(t.coefficient + "x^" + t.degree);
            }
            else if((i < polysize && t.coefficient!=0 & t.degree==0 && i == 0))
            {
                builder.append(t.coefficient);   
            }
            else if((i < polysize && t.coefficient > 0 & t.degree!=0 && i > 0))
                builder.append("+" + t.coefficient + "x^" + t.degree);
            else if((i < polysize && t.coefficient < 0 & t.degree!=0 && i > 0))
                builder.append(t.coefficient + "x^" + t.degree);
            else if((i < polysize && t.coefficient > 0 & t.degree==0 && i > 0))
                builder.append("+" + t.coefficient);
            else if((i < polysize && t.coefficient < 0 & t.degree==0 && i > 0))
                builder.append(t.coefficient);
        }
        return builder.toString();
    }
} // end of Polynomial class

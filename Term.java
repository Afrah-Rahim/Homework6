/**
 * Term class used within polynomial.
 *
 * @author (Akash Jadonandan) 
 * @version (05/8/2017)
 */
public class Term implements Comparable<Term>{

    public int coefficient;
    public int degree;

    /**
     *Creates a term
     *
     *@param coefficient - coefficient of Term
     *@param degree - degree of Term
     *@return Term
     */
    public Term(int coefficient, int degree){
        this.coefficient = coefficient;
        this.degree = degree;
    }

    /**
     *Takes two terms and adds them together.
     *
     *@param t1 - first term to add
     *@param t2 - second term to add
     *@return Term a new Term.
     */
    public static Term add(Term t1, Term t2){
        if(t1.compareTo(t2) != 0)
            throw new RuntimeException("Cannot add terms that do not have the same exponent");
        return new Term(t1.coefficient + t2.coefficient, t1.degree);
    }

    @Override
    public int compareTo(Term t){
        if(this.degree < t.degree)
            return -1;
        else if (this.degree > t.degree)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString(){
        if(degree!=0)
        {
            return this.coefficient + "x^" + this.degree;
        }
        else
        {
            return String.valueOf(coefficient);
        }
    }
}
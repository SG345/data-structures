package structures;
/**
*<h1>Ratio</h1>
*The Ratio class takes a numerator and denominator, and reduces it to it's simplest form
*It makes use of <b>Euclid's GCD Algorithm</b>
*The greatest common divisor(gcd) is also known as the greatest common factor (gcf), highest *common factor (hcf), greatest common measure (gcm), or highest common divisor.
*
*@author: Devesh Shetty
*/
public class Ratio{
    
    //numerator of ratio
    private int numerator;
    //denominator of ratio
    private int denominator;
    private static int counter;
    private int count;
    /**
    *This constructor constructs a Ratio object with the supplied parameters
    *
    *@param numerator This is the numerator of the ratio to be formed
    *@param denominator This is the denominator of the ratio to be formed
    *@exception IllegalArgumentException On supplying 0 as the denominator
    */
    public Ratio(int numerator, int denominator) 
    //pre: denominator !=0
    //post: constructs a ratio equivalent to numerator/denominator
    {
        this.numerator = numerator;
        if(denominator == 0){
            //throw exception when user tries to divide by zero
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
        this.denominator = denominator;
        count = (++counter);
        reduce();
    }
    
    /**
    * Getter for numerator
    *@return numerator
    */
    public int getNumerator()
    //post: return the numerator of the fraction
    {
        return this.numerator;
    }
    
    /**
    * Getter for denominator
    *@return denominator
    */
    public int getDenominator()
    //post: return the denominator of the fraction
    {
        return this.denominator;
    }
    
    /**
    *This method is used to get the fractional value
    *
    *@return the double equivalent of the ratio
    */
    public double getValue()
    //post: return the double equivalent of the value
    {
        return (double)numerator/(double)denominator;
    }
    
    /*
    *A utility method to reduce the ratio to it's simplest form
    */
    private void reduce()
    {
        int divisor = gcd(this.numerator, this.denominator);
        numerator /= divisor;
        denominator /= divisor;
    }
    
    /**
    *A utility method to calculate the greatest common divisor of the numbers supplied
    *It makes use of <b>Euclid's GCD Algorithm</b>
    *@param a the first number 
    *@param b the second number
    *@return the greatest common divisor
    */
    private static int gcd(int a, int b)
    //post: computes the greatest integer value that divides both a and b
    {
        if(a == 0)
        {
            return b;
        }
        else if(a > b){
            // since,  gcd(a,b) == gcd(a%b,b)
            return gcd(a%b,b);
        }
        else
        {
            //b > a
            return gcd(b%a,a);
        }
    
    }
    
    /**
    * @return the String representation of the Ratio Object in the form numerator/denominator
    */
    public String toString()
    //post: return a string that represents the ratio
    {
        return "Object Number: "+this.count+" => "+this.getNumerator()+"/"+this.getDenominator();
    }
    
}
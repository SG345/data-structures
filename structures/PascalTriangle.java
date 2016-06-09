package structures;

/**
*Pascal Triangle
*
* Pascal's triangle is a triangular array of the binomial coefficients
* Having the indices of both rows and columns start at zero makes it possible to state that the binomial coefficient 
n
k
 appears in the nth row and kth column of Pascal's triangle
*
*@author: Devesh Shetty
*/
public class PascalTriangle{
    
    /**
    *This method builds the pascal triangle upto row n
    *
    *@param n the no of rows
    *@exception throws IllegalArgumentException when n < 1
    *@return the multi-dimensional array representing Pascal Triangle
    */
    public static int[][] generatePascalTriangle(int n){
        return new int[10][10];    
    }
    
}
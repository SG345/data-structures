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
    
    public PascalTriangle(){
        
    }
    
    //the multi-dimensional array containing the pascal triangle
    private int result[][];
    
    /**
    *This method builds the pascal triangle upto row n
    *
    *@param n the no of rows
    *@exception throws IllegalArgumentException when n < 1
    *
    */
    public void generatePascalTriangle(int n){
        
        if(n < 1){
            throw new IllegalArgumentException("No of rows cannot be less than 1");    
        }
        
        //create a multidimensional array
        //which has n rows and column length is equal to (n+1)
        //so each row has different column length
        int res[][] = new int[n][];
        
        //i is used for row
        for(int i = 0; i < n; i++){
            
            //assigning column to every row
            res[i] = new int[ i+1 ];
            
            //for each and every row, starting and ending index of column will be equal to 1
            //assign start column index to 1
            res[i][0] = 1;
            
            //j will start from 1 since 0th index will always have the value 1 and end at (i-1)th index since at j = i;i.e., the end column index the value will always be 1
            //j is used for column
            for(int j = 1; j < i;j++){
                //res(i,j) = res(i-1,j-1) + res(i-1,j)
                //res(i,j) is dependent on the previous row elements
                res[i][j] = res[ i-1 ][ j-1 ] + res[ i-1 ][ j ];
            }
            
            //last index of column will have the value of 1
            res[i][i] = 1;
            
        }
        
        this.result =  res;    
    }
    
    public void printPascalTriangle(){
        
        //the total no of rows
        int noOfRows = result.length;
        
        //the count of spaces on each line
        int spaces = noOfRows - 1;
        
        for(int i = 0; i < noOfRows; i++){
            
            for(int k = 0; k < spaces; k++){
                
                System.out.print(" ");
                
            }
            
            spaces--;
            
            for(int j = 0; j < result[i].length; j++){
                
                System.out.print(this.result[i][j]+" "); 
                
            }
            
            System.out.println();
            
        }
        
        
    }
    
    
}
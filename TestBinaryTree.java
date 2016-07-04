import structures.BinaryTree;
import java.io.*;

class Main{

    public static void main(String[] args){
        
        PrintWriter out = new PrintWriter(System.out);
        try
        {
            out.println(new BinarySearch(new int[]{90,12,3,101,4,5,1},1));
            //Best Case: Already sorted
            out.println(new BinarySearch(new int[]{1,2,3,4,5,6,7},8));
            //Worst case: Array is reverse sorted            
            out.println(new BinarySearch(new int[]{9,8,7,6,5,4,3,2,1},8));
            //should throw an exception            
            out.println(new BinarySearch(new int[]{1}));
            
        }
        finally
        {
            out.flush();
        }
    }
    
}
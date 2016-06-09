import structures.PascalTriangle;
import java.io.*;
import java.util.*;

class Main{
    
    private static PrintWriter out = new PrintWriter(System.out,true);
        
    
    public static void main(String []args){
       
        Random r = new Random();
        PascalTriangle pt = new PascalTriangle();
        
        for(int i = 0; i< 5; i++){
            
            int n = r.nextInt(10);
            out.println("*********Pascal Triangle upto "+n+" rows***********");
            
            pt.generatePascalTriangle(n);
            pt.printPascalTriangle();
            
            
            out.println("****************************************************");
            out.println();
        }
       
    }
    
    
  
}
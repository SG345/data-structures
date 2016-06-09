import structures.SieveOfEratosthenes;
import java.io.*;
import java.util.*;

class Main{
    
    public static void main(String []args){
        
        PrintWriter out = new PrintWriter(System.out,true);
        Random r = new Random();
        for(int i = 0; i< 3;i++){
            int n = r.nextInt(700);
            System.out.println("***************Prime upto "+n+"*****************");
            
            SieveOfEratosthenes.printPrimes( n ) ;
            
            System.out.println("**************************************");
        }
    }
    
    
  
}
import structures.SieveOfEratosthenes;
import java.io.*;
import java.util.*;

class Main{
    
    public static void main(String []args){
        
        PrintWriter out = new PrintWriter(System.out,true);
        Random r = new Random();
        for(int i = 0; i< 10;i++){
            SieveOfEratosthenes.printPrimes(r.nextInt(700));
        }
    }
    
    
  
}
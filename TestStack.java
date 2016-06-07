import structures.Stack;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

class Main{
    
    public static void main(String []args){
        PrintWriter out = new PrintWriter(System.out, true);
        
        Stack s1 = new Stack();
        s1.push("The");
        s1.push("dog");
        //should print in reverse
        out.println(s1);
        
        Stack s2 = new Stack();
        s2.push("One");
        s2.push("Two");
        s2.push("Three");
        out.println(s2);
        s2.pop();
        s2.push("Four");
        out.println(s2);
        
        Stack s3 = new Stack();
        Random r = new Random(255);
        for(int i = 0; i <= 10;i++){
            int n = r.nextInt();
            if( (n & (n-1))== 0 ){
                //even no 
                out.println("Pushing data = "+n);
                s3.push("Data "+n);
            }
            else if(!s3.isEmpty()){
                //stack is not empty then pop
                out.println("Poping "+s3.pop());
            }
            
        }
        out.println("************Randomized*************");
        out.println(s3);
        out.println("***********************************");
        
        Stack s4 = new Stack();
        out.println("isEmpty: "+s4.isEmpty());
        s4.pop();//should throw an null pointer exception
        
        
    }
    
    
    
}
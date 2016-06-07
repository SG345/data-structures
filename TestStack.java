import structures.Stack;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

class Main{
    
    public static void main(String []args){
        PrintWriter out = new PrintWriter(System.out, true);
        
        Stack s1 = new Stack();
        for(char i = 'a';i <= 'z'; i++){
            //adding the alphabets to the stack
            s1.push(i);
        }
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
        
        out.println("\n************Randomized*************");
        Stack s3 = new Stack();
        Random r = new Random();
        for(int i = 0; i <= 10;i++){
            int n = r.nextInt(200);
            if( (n & 1) == 0 ){
                //indicates first bit is 0 so now is even
                //even no 
                out.println("Pushing data = "+n);
                s3.push(""+n);
            }
            else if(!s3.isEmpty()){
                //stack is not empty then pop
                out.println("Poping "+s3.pop());
            }
            
        }
        out.println(s3);
        out.println("***********************************");
        
        Stack s4 = new Stack();
        out.println("isEmpty: "+s4.isEmpty());
        s4.pop();//should throw an null pointer exception
        
        
    }
    
    
    
}
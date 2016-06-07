import structures.Stack;
import java.io.*;
import java.util.Arrays;

class Main{
    
    public static void main(String []args){
        PrintWriter out = new PrintWriter(System.out, true);
        
        Stack s1 = new Stack();
        s1.push("The");
        s1.push("dog");
        //should print in reverse
        out.println(s1);
        
        Stack s2 = new Stack();
        s2.push("Test2");
        
        
        Stack s4 = new Stack();
        s4.pop();//should throw an null pointer exception
        
        
    }
    
    
    
}
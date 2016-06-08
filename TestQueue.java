import structures.Queue;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

class Main{
    
    public static void main(String []args){
        PrintWriter out = new PrintWriter(System.out, true);
        
        Queue q1 = new Queue();
        for(char i = 'a';i <= 'z'; i++){
            //adding the alphabets to the queue
            q1.enqueue(i);
        }
        out.println(q1);
        
        Queue q2 = new Queue();
        q2.enqueue("One");
        q2.enqueue("Two");
        q2.enqueue("Three");
        out.println(q2);
        q2.dequeue();
        q2.enqueue("Four");
        out.println(q2);
        for(int i = 1; i<=3;i++){
            q2.dequeue();    
        }
        out.println(q2);
        
        out.println("\n************Randomized*************");
        Queue q3 = new Queue();
        Random r = new Random();
        for(int i = 0; i <= 10;i++){
            int n = r.nextInt(200);
            if( (n & 1) == 0 ){
                //indicates first bit is 0 so now is even
                //even no 
                out.println("Enqueuing data = "+n);
                q3.enqueue(""+n);
            }
            else if(!q3.isEmpty()){
                //stack is not empty then pop
                out.println("Dequeuing "+q3.dequeue());
            }
            
        }
        out.println(q3);
        out.println("***********************************");
        
        Queue q4 = new Queue();
        out.println("isEmpty: "+q4.isEmpty());
        q4.dequeue();//should throw an null pointer exception
        
        
    }
    
    
    
}
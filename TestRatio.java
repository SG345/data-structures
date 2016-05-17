import structures.*;
import java.io.*;

class Main{

    public static void main(String[] args){
        
        PrintWriter out = new PrintWriter(System.out);
        try
        {
            out.println(new Ratio(12,6));
            out.println(new Ratio(6,12));
            out.println(new Ratio(0,13));
            out.println(new Ratio(3,13));
            out.println(new Ratio(666,333));
            //should throw an exception
            out.println(new Ratio(6,0));
            
        }
        finally
        {
            out.flush();
        }
    }
    
}
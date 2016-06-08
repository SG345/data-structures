import structures.SelectionSort;
import java.io.*;
import java.util.*;

class Main{
    
    public static void main(String []args){
        
        int t1[] = {1,2,3,4,5,6};
        int t2[] = {900,800,700,300,100,10,5,1};
        int t3[] ={5,6,1,200,98,12,34};
        Random r = new Random();
        int t4[] = new int[10];
        for(int i = 0;i<t4.length;i++){
            t4[i] = r.nextInt(600);
        }
        
        printCustom(t1);
        printCustom(t2);
        printCustom(t3);
        printCustom(t4);
    }
    
    
    public static void printCustom(int t[]){
        PrintWriter out = new PrintWriter(System.out,true);
        out.println("Before sorting");
        out.println(Arrays.toString(t));
        SelectionSort.sort(t);
        out.println("After sorting");
        out.println(Arrays.toString(t));
        
    }
    
}
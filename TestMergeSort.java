import structures.MergeSort;
import java.io.*;
import java.util.Arrays;

class Main{
    
    public static void main(String []args){
        
        int t1[] = {1,2,3,4,5,6};
        int t2[] = {900,800,700,300,100,10,5,1};
        int t3[] ={5,6,1,200,98,12,34};
        printCustom(t1);
        printCustom(t2);
        printCustom(t3);
    }
    
    
    public static void printCustom(int t[]){
        PrintWriter out = new PrintWriter(System.out,true);
        out.println("Before sorting");
        out.println(Arrays.toString(t));
        MergeSort.sort(t);
        out.println("After sorting");
        out.println(Arrays.toString(t));
        
    }
    
}
import structures.MaximumSubArray;
import java.io.*;
import java.util.Arrays;

class Main{
    
    public static void main(String []args){
        
        int t1[] = {1,2,3,4,5,6};//res should contain the entire array
        int t2[] = {-900,-800,-700,-300,-100,-10,-5,-1};
        int t3[] ={5,-6,-1,-2,98,12,34,-900};
        int t4[] ={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int t5[] = {12,1,2,-90,-100,100,23};
        int t6[] = {300,2,-50,23,45,-45,50};//result should contain the entire array
        
        printCustom(t1);
        printCustom(t2);
        printCustom(t3);
        printCustom(t4);
        printCustom(t5);
        printCustom(t6);
    }
    
    
    public static void printCustom(int t[]){
        PrintWriter out = new PrintWriter(System.out,true);
        out.println("********** ***********");
        out.println(Arrays.toString(t));
        out.println("The max sub-array Details ");
        int res[] = new int[3];
        res = MaximumSubArray.findMaximumSubArray(t, 0, t.length - 1, res, "-" );
        out.println("The start index: "+res[0]);
        out.println("The end index: "+res[1]);
        out.println("The sum= "+res[2]);
        out.println();
    }
    
}
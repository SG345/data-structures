package structures;
/**
*<h1>BubbleSort </h1>
*<p>
*The bubble sort makes multiple passes through a list. It compares adjacent items and exchanges those that are out of order. 
*Each pass through the list places the next largest value in its proper place. In essence, each item “bubbles” up to the location where it belongs.
*
*Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
*Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
*Auxiliary Space: O(1)
*Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
*Sorting In Place: Yes
*Stable: Yes
*
*@author: Devesh Shetty
*/
public class BubbleSort
{

    private int array[];
    
    /**
    *This constructor constructs a sorted array using BubbleSort algorithm
    *
    *@param array[] This is an unsorted integer array
    *@exception IllegalArgumentException throw an exception when length of array is <= 1
    */
    public BubbleSort(int array[])
    //pre: length of array should be greater than one 
    //post: construct a sorted array using BubbleSort algorithm
    {
        if(array.length <= 1){
            //throw an exception when array length is less than 1
            throw new IllegalArgumentException("Array length should be more than 1");
        }
        this.array = array;
        
        bubbleSort(array);
    }
    
    
    /**
    *This method sorts an unsorted array using bubbleSort algorithm
    *
    *@param array[] Array which is to be sorted
    */
    private static void bubbleSort(int array[])
    {
        int length = array.length;
        for(int i = 0; i < length - 1; i++){
            for(int j=0; j < length - i - 1; j++){
                if(array[j] > array[j+1])
                {
                    //swap the numbers 
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    /**
    *
    *Getter for integer array
    */
    public int[] getArray()
    //post: returns the sorted integer array
    {
        return this.array;
    }
    
    /**
    *Print string representation of the object
    */
    public String toString()
    {
        String res = "Array\n[ ";
        
        for(int x : array)
        {
            res += x+" ";
        }        
        
        res += "]";
        
        return res;
    }
    
    
    
}
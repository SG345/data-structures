package structures;


/**
*Insertion Sort
*Sorts the array in place
*
*Best case: O(n); array already sorted
*Worst case: O(n^2); array contains elements in non-decreasing order
*@author: Devesh Shetty
*/
public class InsertionSort{
    
    /**
    *Sorts the array in non-decreasing order
    *Elements in the array who need to be sorted are known as key
    *@param arr the array to be sorted in non-decreasing order
    */
    public static void sort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            // elements in the array to the left of i value are considered to be in sorted order
            //key contains the element we need to place in the left of the array such elements < key are smaller than it
            int key = arr[i];
            int j = i - 1;
            while( j >= 0 && arr[j] > key){
                //shift the elememts one position to the right
                arr[j + 1] = arr[j];
                j--;
            }
            //place the key value in it's position
            arr[j + 1] = key;
            
        }
    }
    
}
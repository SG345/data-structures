package structures;
import java.util.Arrays;
/**
*MergeSort
*It uses divide and conquer stratergy
*The time complexity of merge sort = O(nlog n); where log n is log of n to base 2
*The space complexity is O(n)
*@author: Devesh Shetty
*/
public class MergeSort{
 
    public static void sort(int arr[])
    {
        mergeSort(arr, 0 , arr.length - 1 );
    }
    
    /**
    *This method divides the array into sub-arrays
    *conquers the sub-arrays,i.e., sort the sub-arrays in non-decreasing order
    *combine/merge the sub-arrays
    *This method repeatedly calls merge method to combine the sub-arrays
    *@param arr[] the integer array
    *@param p start index of the array
    *@param r end index of the array
    */
    private static void mergeSort(int arr[], int p,int r){
        if( p < r ){
            int q = (p+r)/2;
            mergeSort(arr, p , q);
            mergeSort(arr, q+1, r);
            merge(arr, p , q, r);
            
        }
    }
    
    /**
    *This method merges the left and right sub-array
    *Compares the element in left and right sub-array and adds the smallest element to output array
    *@param arr[] the integer array
    *@param p start index of the left sub-array
    *@param q end index of the left sub-array
    *@param r end index of the right sub-array
    */
    private static void merge(int arr[], int p, int q, int r){
        
        int left[] = new int[q - p + 1]//left sub-array
            , right[] = new int[ r - q ];//right sub-array;

        //left sub-array will contain elements from p to q(inclusive)
        for(int i = 0; i < left.length; i++){
            left[i] = arr[ p + i];
        }
        
        //right sub-array will contain elements from q+1 to r
        for(int i = 0;i < right.length;i++){
            right[i] = arr[ q + 1 + i ];
        }
        
        int i = 0,//index pointer for left sub-array
            j = 0,//index pointer for right sub-array
            k = p;//index pointer for output array;i.e; initially pointing to start element of the array
        
        while( (i < left.length) & (j < right.length) ){
            if( left[i] <= right[j]){
                //element in left sub-array is smaller or equal
                //copy the element into the output array
                arr[ k] = left[i];
                //increment the left sub-array index pointer
                i++;
            }
            else{
                //element in right sub-array is smaller
                //copy the element from right sub-array to output array
                arr[ k] = right[j];
                //increment the right sub-array index pointer
                j++;
                
            }
            //increment output array pointer
            k++;
        }
        
        //copy the remaining elements from left sub-array if any
        for( ; i < left.length; i++){
            arr[k] = left[i];
            k++;//increment output array index pointer
        }
        
        //copy the remaining elements from right sub-array if any
        for( ; j< right.length; j++){
            arr[k] = right[j];
            k++;//increment output array index pointer
        }
        
        
    }
    
}
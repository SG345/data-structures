package structures;

/**
*SelectionSort
*
*On every iteration and it picks the minimum out of the remaining and puts it in it's correct position
*
*@author: Devesh Shetty
*/
public class SelectionSort{
    
   
    /**
    *@param arr the integer array to be sorted
    */
    public static void sort(int arr[]){
       
        for(int i = 0; i< arr.length;i++){
            
            //the index of minimum value
            int minIndex = i;
            
            for(int j = i+1;j< arr.length;j++){
                //find the minimum in the array of length (arr.length - i)
                if( arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //swap the value of minimum with i index
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            
            //on every iteration, the minimum value is placed at the ith position
        }
        
    }
    
}
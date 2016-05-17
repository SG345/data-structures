package structures;

import structure.BubbleSort;


/**
*<h1>Binary Search </h1>
*
* Binary search is used to quickly find a value in a sorted sequence
*Complexity : O(log n)
*Constraint : Should be sorted in ascending order
*@author: Devesh Shetty
*/
public class BinarySearch{
    
    //TODO: very tightly coupled to BubbleSort, must some other pattern
    //Very poorly designed, has flaws
    
    //array to be searched in
    private int array[];
    
    //position of the element to be searched
    //NOTE: this position is in context with the new sorted array
    private int position = -1;
    
    /**
    *This constructor takes an integer array and first sorts it ascending order
    *@param array[] an integer array
    *@param element the element to be searched
    */
    public BinarySearch(int array[], int element)
    //pre: an integer array
    //post: a sorted integer array with the position of the element
    {
        //very tightly coupled with BubbleSort, must use a pattern to resolve this issue
        BubbleSort sortedArray = new BubbleSort(array);
        this.array = sortedArray.getArray();
        this.position = findByBinarySearch(this.array,element);
    }
    
    /**
    *This constructor takes an integer array and sorts it in ascending order
    *@param array an integer array
    */
    public BinarySearch(int array[])
    //pre: integer array
    //post: sorted integer array
    {
        BubbleSort sortedArray = new BubbleSort(array);
        this.array = sortedArray.getArray();
    }
    
    /**
    *This
    *@param array[] sorted integer array
    *@param element the element whose position is to be determined
    *@return position of the element in the sorted array else returns 1 if element not found
    */
    private static int findByBinarySearch(int array[], int element)
    //pre: sorted integer array
    //post: position of the element to be searched
    {
        int position = -1;
        int low = 0;
        int high = array.length;
        
        while(low <= high)
        {
            //we try to achieve the element's position by comparing it with mid value
            //we adjust the high and low value accordingly
            int mid = low + (high - low)/2;
            
            if(array[mid] == element){
                //element found
                position = mid;
            }
            else if(element > array[mid]){
                //if element > mid value that indicates it is in the right portion of the array
                low = mid+1;
            }
            else{
            //element is smaller the mid value indicates element is in the left portion of the array
                high = mid - 1;
            }
        }
        //returns -1 if element was not found,i.e., the loop ended with no results
        return position;
    }
    
    /**
    *@return position of the element 
    */
    public int getPosition(){
        return this.position;
    }
    
    public String toString()
    {
        return Arrays.toString(this.array) +"\n Position: "+this.position;
        
    }
    
    
}
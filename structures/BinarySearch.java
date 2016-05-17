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
    
    //array to be searched in
    private int array[];
    
    //position of the element to be searched
    //NOTE: this position is in context with the new sorted array
    private int position;
    
    /**
    *This constructor and takes an integer array and first sorts it ascending order
    *@param array[] an integer array
    *@param element the element to be searched
    */
    public BinarySearch(int array[], int element)
    //pre: an integer array
    //post: a sorted integer array
    {
        //very tightly coupled with BubbleSort, must use a pattern to resolve this issue
        BubbleSort sortedArray = new BubbleSort(array);
        this.array = sortedArray.getArray();
        this.position = findByBinarySearch(array,element);
    }
    
    /**
    *
    */
    private int findByBinarySearch(int array[], int element)
    {
        
    }
    
    
    
}
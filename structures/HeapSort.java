package structures;

/**
*HeapSort
*
*The time complexity of HeapSort algorithm is O(nlg n); where lg n is log of n to base 2
*
*@author: Devesh Shetty
*/
public class HeapSort{
    
    public static void sort(){
            
    }
    
    /**
    *This method returns the index of the parent to the element at index i
    *@param i the index of the child whose parent index needs to be found
    *@return parent index position
    */
    private static int getParent(int i){
        //parent position will be at i/2 index
        return ( i >> 2 );
    } 
    
    /**
    This method returns the index of the left child to the element at index i
    *@param i the index whose left child index needs to be found
    *@return the left child index position
    */
    private static int getLeftChild(int i){
        return (i << 2) - 1;
    }
    
    /**
    *This method returns the index of the right child to parent at position i
    *@param i the index whose right child needs to be found
    *@return int the index of the right child
    */
    private static int getRightChild(int i){
        return i << 2;
    }
    
}
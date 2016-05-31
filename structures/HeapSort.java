package structures;

/**
*HeapSort
*It makes of the heap data structure; the heap data structure is an array object that can be viewed as a complete binary tree
*The time complexity of HeapSort algorithm is O(nlg n); where lg n is log of n to base 2
*
*@author: Devesh Shetty
*/
public class HeapSort{
    
    /**
    *A helper method that returns the index of the parent to the element at index i
    *@param i the index of the child whose parent index needs to be found
    *@return parent index position
    */
    private static int getParent(int i){
        //parent position will be at (i-1)/2 index for 0 based array indexes
        return ( (i-1) >> 1 );
    } 
    
    /**
    *A helper method that returns the index of the left child to the element at index i
    *@param i the index whose left child index needs to be found
    *@return the left child index position
    */
    private static int getLeftChild(int i){
        //left child will be at position at i*2 + 1 for 0 based array indexes
        return (i << 1) + 1;
    }
    
    /**
    *A helper method that returns the index of the right child to parent at position i
    *@param i the index whose right child needs to be found
    *@return int the index of the right child
    */
    private static int getRightChild(int i){
        //right child will be at position at i*2+2 for 0 based array indexes
        return (i << 1) + 2;
    }
    
    /**
    *This method makes use of the HeapSort algorithm to sort the integer array in  non-decreasing fashion
    *@param arr the integer array
    */
    public static void sort(int arr[]){
        //build the maxHeap
        buildMaxHeap(arr);
        int heapSize = arr.length - 1;//size of the heap
        for(int i = arr.length - 1; i>=1; i--){
            //since, after building the first max-heap
            //the element stored at index 0 is the one with highest value
            //we exchange it with the element stored at last position
            int temp = arr[0];//arr[0] contains the largest value
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapSize--;//decrement the size of the heap, since the largest element is now stored at index i and we no longer wish to alter it's position
            
            maxHeapify(arr, 0, heapSize);//build the maxHeap again but this time with one element less than the previous one
            
        }
        
    }
    
    /**
    *This method builds the max heap
    *@param arr[] the integer array
    */
    private static void buildMaxHeap(int arr[]){
        //size of the heap
        int heapSize = arr.length - 1;
        // the elements in the subarray A[ (n/2 + 1) ... n] are all leaves of the tree
        for( int i = (arr.length - 1)/2 ; i >= 0; i-- ){
            maxHeapify(arr, i, heapSize);
        }
    }
    
    /**
    *This method lets the value at index i float down in the max-heap when binary trees rooted at getLeftChild(i) and getRightChild(i) are max-heaps, but that the element at index i may be smaller than it's children
    *
    *In max-heap, the max-heap property for every node other than root is A[getParent(i)] >= A[i]
    *
    *@param arr the integer array
    *@param i the index
    *@param heapSize the size of the heap
    */
    private static void maxHeapify(int arr[], int i, int heapSize){
        
        int leftChildIndex = getLeftChild(i),//the left child index
            rightChildIndex = getRightChild(i);//the right child index
        
        //assume largest to be the element at index i
        int largest = i;//stores the index value of the largest of three: i, leftChild(i), rightChild(i)
        //System.out.println("Parent= "+i+" Left= "+leftChildIndex +" Right= "+rightChildIndex+" HeapSize= "+heapSize);
        if(leftChildIndex <= heapSize && arr[leftChildIndex] > arr[i]){
            //left child has a greater value than i
            largest = leftChildIndex;
        }
        
        if(rightChildIndex <= heapSize && arr[rightChildIndex] > arr[largest] ){
            //right child has a greater value
            largest = rightChildIndex;
        }
        
        if( largest != i){
            //indicates one of the child has a greater value than it's parent(i.e. arr[i])
            //exchange the element stored at arr[i] with the a[largest]
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            
            maxHeapify(arr, largest, heapSize);
        }
        
        
    }
    
}
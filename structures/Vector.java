package structures;
/**
*<h1>Vector</h1>
*<p>
*Vector containers are implemented as dynamic arrays; Just as regular arrays, vector containers have their elements stored in contiguous storage locations, which means that their elements can be accessed not only using iterators but also using offsets on regular pointers to elements.
*But unlike regular arrays, storage in vectors is handled automatically, allowing it to be expanded and contracted as needed.
*Vectors can hold any object. They still allow access in constant time to individual elements via index, just like an array.
*
*@author: Devesh Shetty
*/
public class Vector
{
    //the data
    private Object data[];
    //the element count
    private int elementCount;
    //the increment
    private int capacityIncrement;
    
    /**
    *
    *This constructor sets the initial capacity of vector to 10
    */
    public Vector(){
        //setting the initial capacity as 10
        this(10);
    }
    
    /**
    *This constructor uses the intial capacity specified by the user
    *@param initialCapacity the initial capacity of the vector
    *@exception IllegalArgumentException when initialCapacity specified is negative
    */
    public Vector(int initialCapacity)
    {
        if(initialCapacity < 0){
            //throw an exception if it is negative
            throw new IllegalArgumentException("InitialCapacity can not be negative");
        }
        data = new Object[initialCapacity];
        elementCount = 0;
    }

    /**
    *This constructor uses the initialCapacity to create a vector of the specified size and also has an capacityIncrement value to resize the vector when it is full
    *
    *@param initialCapacity the initial size of the vector
    *@param capacityIncrement the capacity increment value
    *@exception IllegalArgumentException if supplied capacity or increment is < 0
    */
    public Vector(int initialCapacity, int capacityIncrement){
        if(initialCapacity < 0 || capacityIncrement < 0){
            throw new IllegalArgumentException("capacity or increment can not be negative");
        }
        
        data = new Object[initialCapacity];
        elementCount = 0;
        this.capacityIncrement = capacityIncrement;
        
    }
    
    /**
    *This is a getter method to get the object at specified index
    *@param index the location whose value is to be fetched in a vector
    *@return Object if value exists at given index location, else returns null
    *@exception ArrayIndexOutOfBoundsException if the index value is greater than or equal to the size of the vector
    */
    public Object get(int index){
        if(index >= this.size() || index < 0){
            //index should be <  size()
            throw new ArrayIndexOutOfBoundsException("Invalid Index");
        }
        return data[index];
    }
    
    /**
    *This is a setter method to set the value at the specified index in the vector
    *The previous value at the specified location will be lost
    *
    *@param index the index at which the value is to be entered
    *@param obj the object which is to be stored at the specified index
    *@return Object the object which was previously stored at the specified index (may also return null if no value existed previously)
    *@exception ArrayIndexOutOfBoundsException On supplying an index value greater than the size of the vector
    */
    public Object set(int index, Object obj){
        if(index >= size() || index < 0){
            throw new ArrayIndexOutOfBoundsException("Invalid index value supplied");    
        }
        
        Object previous = data[index];
        data[index] = obj;
        return previous;
    }
    
    /**
    *Adds the element to the end of the vector
    *If available capacity is less, then the vector size is increased
    *@param obj the object to be added to the vector
    */
    public void add(Object obj){
        //ensure if sufficient capacity is available
        ensureCapacity(elementCount+1);
        //add the element to the end of the vector
        data[elementCount] = obj;
        elementCount++;
    }
    
    /**
    *Add the element to the specified index
    *@param index the particular index at which element has to be added
    *@param obj the element which is to be added
    *@exception ArrayIndexOutOfBoundsException on supplying an invalid index
    */
    public void add(int index, Object obj){
        if(index >= this.size() || index < 0){
            throw new ArrayIndexOutOfBoundsException("Invalid Index");
        }
        //ensure sufficient capacity
        ensureCapacity(elementCount + 1);
        //copy elements from right to left without destroying existing data
        for(int i = elementCount; i > index; i--)
        {
            data[i] = data[i-1];
        }
        //after completing the above loop all existing data beyond index value have been shifted one position to the right
        data[index] = obj;
        elementCount++;
    }
    
    /**
    *Removes the element at the specified index and shifts element accordingly
    *
    *@param index the index from where the element is to be removed
    *@return Object return the element which previously existed at the specified index
    *@exception ArrayIndexOutOfBoundsException on supplying an invalid index
    */
    public Object remove(int index){
        if(index >= this.size() || index < 0){
            throw new ArrayIndexOutOfBoundsException("Invalid Index");
        }
        //get the object existing at the specified index
        Object res = this.get(index);
        elementCount --;
        while(index < elementCount){
            //shifting elements to the left
            data[index] = data[index+1];
            index++;
        }
        //empty the value at the last index
        data[elementCount] = null;
        return res;
    }
    
    /**
    *This method checks whether elements exist in the vector or not
    *@return true if there are no elements int the vector else false
    */
    public boolean isEmpty(){
        return this.size() == 0;
    }
    
    /**
    *This method returns the size of the vector
    *@return int size of the vectore
    */
    public int size(){
        return elementCount;
    }
    
    /**
    *This method returns the capacity of the vector
    *@return int the capacity of the vector
    */
    public int capacity(){
        return data.length;
    }
    
    /**
    *This method ensures if the minimum capacity is available. If it is not, it resizes the vector
    *@param minCapacity the minimum capacity the vector should have
    */
    public void ensureCapacity(int minCapacity){
        
        if(this.capacity() < minCapacity){
            int newLength = data.length;
            if(capacityIncrement == 0){
                //if increment is 0, we can use the doubling technique to resize the vector which has the complexity of O(n)
                //1 + 2 + 4 + ... + n/2 = n-1, the total no of times elements were copied 
                if(newLength ==0){
                    newLength = 1;
                }
                while(newLength < minCapacity){
                    //keep on multiplying by 2,i.e, double it
                    newLength<<=1;
                }
            }
            {
                //increase by user specified value
                while(newLength < capacityIncrement){
                    newLength += capacityIncrement;
                }
            }
            
            Object newData[] = new Object[newLength];
            //copy old data to new array
            for(int i = 0;i< elementCount; i++){
                newData[i] = data[i];
            }
            data = newData;
            
        }
        
        //do nothing if capacity of vector is greater than the minimum capacity
        
    }
    
}
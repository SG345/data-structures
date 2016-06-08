package structures;

/**
*Queue
*
*Queue works on the principle of FIFO(First In First Out)
*
*
*@author: Devesh Shetty
*/
public class Queue
{
    /**
    *Every element in the queue is represented in a Node
    */
    private class Node{
        String data;
        Node next;
    }
    
    public Queue(){
        
    }
    
    private Node first,//points to the first item in the queue
                last;//points to the last item in the queue
    
    private int size;//the size of the queue
    
    /**
    *Adds an element to the end of the queue
    *@param data the element to be added to the queue
    */
    public void enqueue(String data){
        
    }
    
    /**
    *
    *@param character data to be added to the queue
    */
    public void enqueue(char data){
        this.enqueue(data+"");
    }
    
    /**
    *Removes and returns the data stored in the first position of the queue
    *
    *@return the data of the element stored at first location in the queue\
    *@exception throws NullPointerException when we try to dequeue a queue which is empty
    */
    public String dequeue(){
        String data = "";
        return data;
    }
    
    /**
    *@return true if queue is empty else false
    */
    public boolean isEmpty(){
        //returns true if queue is empty
        return (first == null);
    }
    
    /**
    *@return the size of the queue
    */
    public int size(){
        return this.size;
    }
    
    public String toString(){
        return "";
    }
    
}
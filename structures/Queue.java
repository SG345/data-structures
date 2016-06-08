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
        
        //create a new node
        Node node = new Node();
        node.data = data;
        node.next = null;
        
        if(first == null){
            //if queue is empty
            //first and last will point to the only node available in the queue
            last = first = node;
        }
        else{
            //add the node to the end of the qeueue
            last.next = node;
            //update the last pointer
            last = last.next;
            
        }
        
        size++;//increment the size of the queue
        
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

        if(this.isEmpty()){
            //nullpointerException since queue is empty
            throw new NullPointerException("Can not dequeue element from an empty queue");
        }
        //remove the node stored at first position in the queue
        String data = first.data;
        //update the first pointer
        first = first.next;
        //decrement the size of the queue
        size--;
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
        String res = "[ ";
        Node temp = first;
        
        while(temp != null){
            res+= temp.data+" ";
            temp = temp.next;
        }
        res+=" ]\n QueueSize= "+this.size();
        
        return res;
    }
    
}
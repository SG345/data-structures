package structures;

/**
*Singly Linked List
*
*Every element in a singly linked list is represented by a node object
*
*The <T> is a type token that signals that this class can have a type set when instantiated
*The <T> should extend extend Comparable so we can make comparisons and create some helper methods
*
*@author: Devesh Shetty
*/
public class SinglyLinkedList<T extends Comparable>{
    
    /**
    *This node object contains the data of type <T> as specified by the user
    */
    private class Node{
        T data;
        Node next;
    }
    
    public SinglyLinkedList(){
        
    }
    
    private Node head,//head pointing to the head of the list
                tail;//tail pointing to the end of the list
    
    private int size;//the size of the list
    
    /**
    *Adds a data item to the end of the list
    *
    *@param data the data to be added to the list
    */
    public void add(T data){
        
        Node node = new Node();
        node.data = data;
        node.next = null;
        
        if( head == null ){
            
            //list is empty
            //first node to be added to the list
            //head and last will point to the one and only node in the list
            head = tail = node;
            
        }
        else{
            
            //list is not empty
            //make the last node point to the new node 
            tail.next = node;
            
            //update the tail node
            tail = tail.next;
            
        }
        
        this.size++;
        
    }
    
    
    /**
    *Sorts the list using the Comparator
    *
    */
    public void sortList(){
        //TODO sorting
    }
    
    /**
    *
    *@return the siz of the list
    */
    public int size(){
        
        return this.size;
    }
    
    /**
    *@return true if the list is empty else false
    */
    public boolean isEmpty(){
    
        return ( head == null );
    }
    
    /**
    *
    *@return a string formatted list starting from head node to tail node
    */
    @Override
    public String toString(){
        String res = "[ ";
        
        Node temp = head;
        
        while( temp != null ){
            res += temp.data + " ";
            //update the temp to the next node
            temp = temp.next;
        }
        
        res += "]";
        
        return res;
    }
    
}
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
    *
    *@return the siz of the list
    */
    public int size(){
        
        return this.size;
    }
    
    
}
package structures;
import java.util.NoSuchElementException;
import structures.node.SLNode;

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
    
    public SinglyLinkedList(){
        
    }
    
    private SLNode head,//head pointing to the head of the list
                tail;//tail pointing to the end of the list
    
    private int size;//the size of the list
    
    /**
    *Adds a data item to the end of the list
    *
    *@param data the data to be added to the list
    */
    public void add(T data){
        
        SLNode node = new SLNode();
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
    *This function will swap the nodes containing the given data1 and data2
    *<b>It will swap the entire node and not the values</b>
    *@param data1
    *@param data2
    */
    public void swapNodes(T data1, T data2){
        //the list is empty
        if(isEmpty()){
            return;
        }
        
        if(data1.equals(data2)){
            return;
        }
        
        SLNode node1 = head,//reference to node containing data1
             node2 = head,//reference to node containing data2
             prev1 = null,//reference to the node before node1
             prev2 = null;//reference to the node before node2
        
        while(node1 != null && !node1.data.equals(data1)){
            prev1 = node1;
            node1 = node1.next;
        }
       
        if(node1 == null){
            throw new NoSuchElementException("Element with value "+data1+" does not exist in the list");
        }
        
        while(node2 != null && !node2.data.equals(data2)){
            prev2 = node2;
            node2 = node2.next;
        }
        
        if(node2 == null){
            throw new NoSuchElementException("Element with value "+data2+" does not exist in the list");
        }
        
        if(prev1 != null){
            prev1.next = node2;
        }else{
            //indicates node1 is the head node
            //make node2 the new head
            head = node2;
        }
        
        if(prev2 != null){
            prev2.next = node1;
        }else{
            //indicates node2 is the head node
            //make node1 the new head
            head = node1;
        }
        
        if(node1.next == null){
            //make node2 as the new tail
            tail = node2;
        }
        
        if(node2.next == null){
            //make node1 as the new tail
            tail = node1;
        }
        
        //node1 and node2 contain references to nodes with values data1 and data2 respectively
        SLNode temp = node2.next;
        node2.next = node1.next;
        node1.next = temp;
        
    }
    
    /**
    *Reverses the list 
    */
    public void reverse(){
        
        if(isEmpty() || size() == 1)
        {
            //the list is empty or the list is of size 1
            return;
        }
        
        SLNode temp = head,//temp will help us to traverse through the entire list
             current = null,//current will point to the current node
             prev = null;//prev will point to the previous node
        
        tail = temp;
        
        while(temp != null){
            current = temp;
            temp = temp.next;
            current.next = prev;
            prev = current;
        }
        head = current;
        
    }
    
    /**
    *Reverses the blocks of elements of size groupSize in the list
    *e.g. 100->200->300->400->600->800 groupSize = 3
    * output: 300->200->100->800->600->400
    *@param blockHead; the Head of the block of list
    *@param groupSize
    *@return the Node pointing the head of the reversed list
    */
    public SLNode reverseInGroups(SLNode blockHead, int groupSize){
        
        if(isEmpty() || size() == 1 || groupSize == 0)
        {
            //the list is empty or the list is of size 1
            return null;
        }
        
        if(groupSize == 1)
        {
            return head;
        }
        
        if(blockHead == null)
        {
            blockHead = this.head;
        }
         
        SLNode temp = blockHead,//temp will help us to traverse through the entire list
            current = null,//current will point to the current node
             prev = null;//prev will point to the previous node
        
        int elementCount = 0;
        
        while(temp != null && elementCount < groupSize)
        {
            current = temp;
            temp = temp.next;
            current.next = prev;
            prev = current;
            elementCount++;
        }
        
        if(temp != null){
            //blockHead will now become the tail of the block
            blockHead.next = reverseInGroups(temp, groupSize);
        }
        //return the head of the block
        return current;
        
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
        
        SLNode temp = head;
        
        while( temp != null ){
            res += temp.data + " ";
            //update the temp to the next node
            temp = temp.next;
        }
        
        res += "]";
        
        return res;
    }
    
}
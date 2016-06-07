package structures;

/**
*Stack
*
*<p>
*Stack uses the principle of LIFO( Last In First Out )
*It can be used to reverse a string
*
*@author: Devesh Shetty
*/
public class Stack{
    
    /**
    *Every item in a stack will be represented in a Node Object
    */
    private class Node{
        
        //the data of the node 
        String stringData;
        //the pointer to the next node
        Node next;
        
    }
    
    //the stack-top pointer
    private Node top;
    
    //the size of the stack
    private int size;
     
    public Stack(){
    
    }
    
    /**
    *Adds the data to the top of the stack
    *@param data the string data to be added to the stack
    */
    public void push(String data){
        
        if(top == null){
            //stack is empty
            
            //add the first node to the stack
            top = new Node();
            top.stringData = data;
            top.next = null;//the first node's next value always points to null
        }
        else{
            //stack in non-empty
            
            Node newNode = new Node();
            newNode.stringData = data;
            //new node will point to the next element to it in the stack
            newNode.next = top;
            
            //make the top pointer point to the new node of the stack
            top = newNode;
        }
        //increment the size of the stack
        size++;
        
    }
    
    /**
    *Adds the data to top of the stack
    *@param data adds the character data to the top of the stack
    */
    public void push(char data){
        //convert the character to string and call the push(String) method
        this.push(data+"");
    }
    
    /**
    *Removes and the returns the element at the top of the stack
    *@return the data item stored at top
    *@exception throws NullPointerException when the stack is empty
    */
    public String pop(){
        
        if(this.isEmpty()){
            //if stack is empty throw NullPointerException
            throw new NullPointerException("Stack is empty");
        }
        //stack is non-empty
        
        //get the data stored at top of the stack
        String data = top.stringData;
        
        //pop the top node, and now let the top pointer point to the next node
        top = top.next;
    
        //decrement the size of the stack
        size--;
        
        return data;
    }

    
    /**
    *Checks if the stack is empty or not
    *@return true if stack is empty or false if non-empty
    */
    public boolean isEmpty(){
        //if top points to null that indicates stack is empty
        return top == null;
    }
   
    /**
    *This method returns the stack-size
    *@return the size of the stack
    */
    public int size(){
        return this.size;
    }
    
    
    public String toString(){
        String res = "[ ";
        //pointer to help us traverse throughout the stack
        Node pointIndex = top;
        //res contains the stack content starting from stack top
        while(pointIndex != null){
            res+= pointIndex.stringData+" ";
            //point to the next node
            pointIndex = pointIndex.next;
        }
        res+=" ] \nStack size: "+this.size();
        return res;
    }
    
    
}
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
    
    public Stack(){
    
    }
    
    //the stack-top pointer
    private Node top;
    
    /**
    *Adds the data to the top of the stack
    *@param data the string data to be added to the stack
    */
    public void push(String data){
        
        if(top == null){
            //stack is empty
        
            top = new Node();
            top.stringData = data;
            top.next = null;
        }
        else{
            //stack in non-empty
            
        }
        
    }
    
    /**
    *
    *@return the data item stored at top
    *@exceptions throws NullPointerException when the stack is empty
    */
    public String pop(){
        
        if(this.isEmpty()){
            //if stack is empty throw NullPointerException
            throw new NullPointerException("Stack is empty");
        }
        //stack is non-empty
        return "";
        
    }

    
    /**
    *Checks if the stack is empty or not
    *@return true if stack is empty or false if non-empty
    */
    public boolean isEmpty(){
        //if top points to null that indicates stack is empty
        return top == null;
    }
    
    
    
}
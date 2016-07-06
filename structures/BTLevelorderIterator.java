package structures;

import structures.BinaryTree;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

/**
*<h1>Level order Traversal</h1>
*
*An iterator which can be used for levelorder traversal of a tree
*
*@author: Devesh Shetty
*/
public class BTLevelorderIterator<E> implements Iterator<E>{
    
    // root of the tree to be traversed
    protected BinaryTree<E> root;
    //queue of unvisisted nodes
    protected Queue<BinaryTree<E>> todo;
    
    /**
    *Construct an iterator to traverse in levelorder
    *
    *@param root of the tree to be traversed
    */
    public BTLevelorderIterator(BinaryTree<E> root){
        todo = new LinkedList<BinaryTree<E>>();
        this.root = root;
        reset();
    }
    
    /**
    *Resets the iterator to retraverse
    */
    public void reset(){
        //empty the queue
        todo.clear();
        if(root != null){
            todo.add(root);
        }
    }
  
    /**
    *@return true if and only if iterator is not finished
    */
    public boolean hasNext(){
        return !todo.isEmpty();
    }
    
    /**
    *It returns the current value and then increments the iterator
    *
    *@return the current value
    */
    public E next(){
        
        BinaryTree<E> current = todo.remove(); 
        
        if(!current.left().isEmpty()){
            todo.add(current.left());
        }
        
        if(!current.right().isEmpty()){
            todo.add(current.right());
        }
        
        return current.value();
    }
    
    /**
    *@return reference to current value
    */
    public E get(){
        return todo.element().value();
    }
    
    public void remove(){
        throw new UnsupportedOperationException();
    }
    
    
}
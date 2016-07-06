package structures;

import structures.BinaryTree;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

/**
*<h1>Preorder Traversal</h1>
*
*An iterator which can be used for postorder traversal of a tree
*
*@author: Devesh Shetty
*/
public class BTPostorderIterator<E> implements Iterator<E>{
    
    // root of the tree to be traversed
    protected BinaryTree<E> root;
    //queue of unvisisted nodes
    protected Queue<BinaryTree<E>> todo;
    
    /**
    *Construct an iterator to traverse in postorder
    *
    *@param root of the tree to be traversed
    */
    public BTPostorderIterator(BinaryTree<E> root){
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
        enqueuePreorder(root);
    }
    
    /**
    *Enqueue all values found in tree rooted at current in preorder
    */
    protected void enqueuePreorder(BinaryTree<E> current){
        //This is an recursive implementation of postorder traversal of a tree
        //as each node of the tree are visited once, the complexity is O(n)
        if(current.isEmpty()){
            return;
        }
        enqueuePreorder(current.left());
        enqueuePreorder(current.right());
        todo.add(current);
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
        return todo.remove().value();
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
package structures;
import java.util.Iterator;
import structures.BinaryTree;

/**
*<h1>Preorder Traversal</h1>
*
*An iterator which can be used for preorder traversal of a tree
*Typically, we visit a node and then each of the nodes in the left subtree, followed by each of the nodes in the right subtree
*
*@author: Devesh Shetty
*/
public class BTPreorderIterator<E> implements Iterator<E>{
    
    public boolean hasNext(){
        return true;
    }
    
    public E next(){
        return null;
    }
    
    public void remove(){
        throw new UnsupportedOperationException();
    }
    
    
}
package structures;
import java.util.Iterator;
/**
*<h1>Binary Tree </h1>
*Trees are hierarchical data structures
*A tree whose elements have at most 2 children is called binary tree.
*Main uses of tree include maintaining hierarchical data, providing moderate access and insert/delete operations
*@author: Devesh Shetty
*/
public class BinaryTree<E>{
    
    //the value of the node
    protected E val;
    //the parent of the node
    protected BinaryTree<E> parent;
    //the children of the node
    protected BinaryTree<E> left, right;
    
    /**
    *Constructor that generates an empty node
    */
    public BinaryTree(){
        
    }
    
    /**
    *Constructor that generates a tree referencing value and two empty sub-trees
    *@param value; the value of the node
    */
    public BinaryTree(E value){
        
    }
    
    /**
    *Constructor that generates a tree referencing the value and two subtrees
    *@param value; the value of the node
    *@param leftsubTree the left sub-tree of the node
    *@param rightsubTree the right sub-tree of the node
    */
    public BinaryTree(E value, BinaryTree<E> leftsubTree, BinaryTree<E> rightsubTree){
        
    }
    
    /**
    *This method returns a reference to left subtree
    *@return left Binary subtree
    */
    public BinaryTree<E> left(){
        
    }
    
    /**
    *This method returns a reference to right subtree
    *@return right Binary subtree
    */
    public BinaryTree<E> right(){
        
    }
    
    /**
    *This method returns a reference to the parent node or null
    *@return the parent if exists else null 
    */
    public BinaryTree<E> parent(){
        
    }
    
    /**
    *This method sets the left subtree to the newLeft
    *re-parents newLeft if not null
    *@param newLeft the Binary subtree
    */
    public void setLeft(BinaryTree<E> newLeft){
        
    }
    
    /**
    *This method sets the right subtree to the newRight
    *re-parents newRight if not null
    *@param newRight the Binary subtree
    */
    public void setRight(BinaryTree<E> newRight){
        
    }
    
    
    /**
    *This method re-parents this node to newParent reference or null
    *@param newParent the new Parent of the tree; it may be null
    */
    protected void setParent(BinaryTree<E> newParent){
        
    }
   
    
    /**
    *
    *@return  an in-order iterator of the elements
    */
    public Iterator<E> iterator(){
        
    }
    
    /**
    *@return true if this is a left child of the parent
    */
    public boolean isLeftChild(){
        
    }
    
    
    /**
    *@return true if this is a right child of the parent
    */
    public boolean isRightChild(){
        
    }
    
    
    /**
    *@return the value associated with this node
    */
    public E value(){
        
    }
    
    
    /**
    *This method sets the vale associated with this node
    *@param the value
    */
    public void setValue(E value){
        
    }
    
    
}
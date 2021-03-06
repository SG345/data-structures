package structures;
import java.util.Iterator;
import structures.BTPreorderIterator;
import structures.BTInorderIterator;
import structures.BTPostorderIterator;
import structures.BTLevelorderIterator;

/**
*<h1>Binary Tree </h1>
*Trees are hierarchical data structures
*A tree whose elements have at most 2 children is called binary tree;i.e, each node except the leaves have a degree of 2.
*Main uses of tree include maintaining hierarchical data, providing moderate access and insert/delete operations
*@author: Devesh Shetty
*/
public class BinaryTree<E>{
    
    //The height of a tree is the height of the root
    
    //Every node of a tree is a descendant of itself
    //A path is the unique shortest sequence of edges from node n to an ancestor
    //The length of the path is the number of edges it mentions
    //The height of a node n in a tree is the length of any longest path between the leaf and n
    //The depth ( or level) of a node n in its tree T is the length of path from n to T's root
    //The degree of a node n is the number of its children
    //The no of nodes in  a full binary tree is 1 less than the number of leaves
    //A full binary tree of height h >=0 has 2^h leaves
    
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
        val = null;
        parent = null;
        left = right = this;
    }
    
    /**
    *Constructor that generates a tree referencing value and two empty sub-trees
    *@param value; the value of the node
    *@exception throws NullPointerException if value supplied is null
    */
    public BinaryTree(E value){
        
        if(value == null){
            throw new NullPointerException("The value must be non-null");
        }
        
        val = value;
        parent = null;
        right = left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }
    
    /**
    *Constructor that generates a tree referencing the value and two subtrees
    *@param value; the value of the node
    *@param left the left sub-tree of the node
    *@param right the right sub-tree of the node
    *@exception throws NullPointerException if value supplied is null
    */
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right){
        
        if(value == null){
            throw new NullPointerException("The value must be non-null");
        }
        
        val = value;
        
        if(left == null){
            left = new BinaryTree<E>();    
        }
        
        setLeft(left);
        
        if(right == null){
            right = new BinaryTree<E>();
        }
        
        setRight(right);
        
    }
    
    /**
    *This method returns a reference to left subtree
    *@return left Binary subtree
    */
    public BinaryTree<E> left(){
        return left;
    }
    
    /**
    *This method returns a reference to right subtree
    *@return right Binary subtree
    */
    public BinaryTree<E> right(){
        return right;
    }
    
    /**
    *This method returns a reference to the parent node or null
    *@return the parent if exists else null 
    */
    public BinaryTree<E> parent(){
        return parent;
    }
    
    /**
    *This method sets the left subtree to the newLeft
    *re-parents newLeft if not null
    *@param newLeft the Binary subtree
    */
    public void setLeft(BinaryTree<E> newLeft){
        
        if(isEmpty()){
            return;
        }
        
        if(left != null && left.parent == this){
            left.setParent(null);
        }
        
        left = newLeft;
        left.setParent(this);
        
    }
    
    /**
    *This method sets the right subtree to the newRight
    *re-parents newRight if not null
    *@param newRight the Binary subtree
    */
    public void setRight(BinaryTree<E> newRight){
        
        if(isEmpty()){
            return;
        }
        
        if(right !=null && right.parent == this){
            right.setParent(null);
        }
        
        right = newRight;
        right.setParent(this);
        
    }
    
    
    /**
    *This method re-parents this node to newParent reference or null
    *@param newParent the new Parent of the tree; it may be null
    */
    protected void setParent(BinaryTree<E> newParent){
        
        if(!isEmpty()){
            parent = newParent;
        }
        
    }
   
    
    /**
    *@param choice == 1, for preorder iterator, choice == 2 for inorder iterator, choice == 3 for postorder iterator
    *@return  an in-order iterator of the elements
    */
    public Iterator<E> iterator(int choice){
        Iterator<E> it = null;
        
        switch(choice){
            case 1: 
                it = new BTPreorderIterator<E>(this);
                break;
            case 2:
                it = new BTInorderIterator<E>(this);
                break;
            case 3: 
                it = new BTPostorderIterator<E>(this);
                break;
            
            case 4:
                it = new BTLevelorderIterator<E>(this);
                break;
        }
        
        return it;
    }
    
    /**
    *@return true if this is a left child of the parent
    */
    public boolean isLeftChild(){
        return (parent.left == this);
    }
    
    
    /**
    *@return true if this is a right child of the parent
    */
    public boolean isRightChild(){
        return (parent.right == this);
    }
    
    
    /**
    *@return the value associated with this node
    */
    public E value(){
        return val;
    }
    
    
    /**
    *This method sets the vale associated with this node
    *@param the value
    */
    public void setValue(E value){
        val = value;
    }
    
    /**
    *@return true if the tree is empty
    */
    public boolean isEmpty(){
      return (val == null);  
    }
    
    /**
    *
    */
    
    /**
    *@return root of the tree
    */
    public BinaryTree<E> root(){
        if(parent == null){
            return this;
        }
        else{
            return parent.root();
        }
        
    }
    
    /**
    *@return depth of the tree
    */
    public int depth(){
        //For full trees, this method approximately has a complexity of O(log n)
        
        if(parent == null){
            return 0;
        }
        
        return 1 + parent.depth();
        
    }
    
    /**
    *@return the height of a node in the tree
    */
    public int height(){
        
        if(isEmpty()){
            return -1;
        }
        //This method takes O(n) time to execute on a subtree with n nodes
        
        //The height of a tree is 1 more than the tallest subtree
        return 1 + Math.max(left.height(), right.height());
        
    }
    
    /**
    *@return the size of subtree
    */
    public int size(){
        
        if(isEmpty()){
            return 0;
        }
        //The complexity is O(n)
        return left.size() + right.size() + 1;
        
    }
    
    /**
    *@return true if and only if tree rooted at n is full
    */
    public boolean isFull(){
        //A full binary tree of height h >= 0 has 2^(h+1) - 1 nodes
        int h = height();
        int s = size();
        //This function has a complexity of O(n)
        //shifting 1 to left h + 1 binary places efficiently computes 2^(h+1)
        return s == ( ( 1 << (h+1)) - 1 );
    }
}
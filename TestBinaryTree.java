import structures.BinaryTree;
import java.io.*;
import java.util.Iterator;

class Main{

    public static void main(String[] args){
        
        BinaryTree<Integer> leftTree = new BinaryTree<Integer>(10);
        leftTree.setLeft(new BinaryTree<Integer>(15));
        leftTree.setRight(new BinaryTree<Integer>(19));
        
        BinaryTree<Integer> rightTree = new BinaryTree<Integer>(30);
        rightTree.setLeft(new BinaryTree<Integer>(32));
        rightTree.setRight(new BinaryTree<Integer>(38));
        
        BinaryTree<Integer> root = new BinaryTree<Integer>(100, leftTree, rightTree);
        
        printTree(root.iterator(1));//preorder
        printTree(root.iterator(2));//in-order
        printTree(root.iterator(3));//postorder
        printTree(root.iterator(4));//levelorder

        printTreeProperties(root);
        printTreeProperties(leftTree);
        printTreeProperties(rightTree);
        
    }
    
    private static void printTree(Iterator it){
        
        System.out.println("*********Traversal*********");
        
        while(it.hasNext()){
            Object val = it.next();
            System.out.println(val);
        }
        
        System.out.println();
    }
    
    private static void printTreeProperties(BinaryTree<Integer> root){
        PrintStream out = System.out;
        out.println("**********Properties*******");
        out.println("Height= "+root.height());
        out.println("Size= "+ root.size());
        out.println("isFull= "+root.isFull() );
        out.println("depth= "+ root.depth());
        out.println("Root node= "+root.root().value() );
        out.println();
    }
    
}


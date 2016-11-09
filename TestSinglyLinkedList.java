import structures.SinglyLinkedList;
import java.io.*;
import java.util.*;
import structures.node.SLNode;

class Main{
    
    public static void main(String []args){
        
        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();
        
        Random r = new Random();
        int initial = (int)'a';
        
        for(int i = 0; i < 26; i++){
            int n = r.nextInt(27);
            char data = (char)( initial + n );
            list.add( data );
        }
        
        System.out.println(list);
        
        list.sortList();
        
        System.out.println(list);
        
        SinglyLinkedList<Integer> integerList = new SinglyLinkedList();
        
        for(int i = 0; i < 20; i++){
            int n = r.nextInt(1000);
            
            integerList.add(n);
            
        }
        
        System.out.println(integerList);
        
        integerList.sortList();
        
        System.out.println(integerList);
        
        
        SinglyLinkedList<Integer> integerList2 = new SinglyLinkedList();
        integerList2.add(2000);
        integerList2.add(1000);
        integerList2.add(3000);
        integerList2.add(4000);
        integerList2.add(10000);
        integerList2.add(5000);
        
        System.out.println(integerList2);
        
        integerList2.swapNodes(2000, 1000);
        integerList2.swapNodes(10000, 5000);
        integerList2.swapNodes(2000, 5000);
        System.out.println(integerList2);

        integerList2.reverse();
        System.out.println(integerList2);

        
        SLNode node = integerList2.reverseInGroups(null, 3);
        
        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
        
    }
    
    
   
    
}
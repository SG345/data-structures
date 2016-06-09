import structures.SinglyLinkedList;
import java.io.*;
import java.util.*;

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
        
    }
    
    
   
    
}
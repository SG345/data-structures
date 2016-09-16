import structures.UnionFind;
import java.io.PrintStream;
import java.util.Random;

class Main{

    public static void main(String[] args){
        
        PrintStream out = System.out;
        UnionFind uf1 = new UnionFind(20);
        out.println("Component 2 to component 7: "+uf1.connected(2, 7));
        Random r = new Random();
        for(int i = 0; i < 30; i++){
            int p = r.nextInt(20);
            int q = r.nextInt(20);
            uf1.union(p, q);
        }
        
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(i == j) continue;
                
                out.println("Site "+i+" connected to Site "+j+" : "+uf1.connected(i, j));
            }
        }
        
    }
    
}
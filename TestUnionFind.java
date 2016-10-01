import structures.UnionFind;
import java.io.PrintStream;
import java.util.Random;

class Main{

    public static void main(String[] args){
        
        PrintStream out = System.out;
        //uses quickFind
        //takes up O(MN) where M is the no of connections and N is the number of sites
        out.println();
        out.println("*************Using QuickFind***************");
        out.println();
        UnionFind uf1 = new UnionFind(20, false);
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
        
        //uses QuickUnion
        //still take up O(MN) in worst case
        out.println();
        out.println("*************Using QuickUnion***************");
        out.println();
        UnionFind uf2 = new UnionFind(30, false);
        
        for(int i = 0; i < 30; i++){
            int p = r.nextInt(25);
            int q = r.nextInt(15);
            uf2.quickUnion(p, q);
        }
        
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 30; j++){
                if(i == j) continue;
                
                out.println("Site "+i+" connected to Site "+j+" : "+uf2.connected(i, j));
            }
        }
        
        //uses WeightedQuickUnion
        //take up O(MlgN)
        out.println();
        out.println("*******************Using WeightedQuickUnion**********");
        out.println();
        UnionFind weightedUF = new UnionFind(50, true);
        for(int i = 0; i < 30; i++){
            int p = r.nextInt(25);
            int q = r.nextInt(15);
            weightedUF.weightedUnion(p, q);
        }
        
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 30; j++){
                if(i == j) continue;
                
                out.println("Site "+i+" connected to Site "+j+" : "+weightedUF.connected(i, j));
            }
        }
        
        
        
        
        
    }
    
}
package structures;

/**
*
*
*@author: Devesh Shetty
*/
public class UnionFind{
 
    //each component will be identified by an id
    //two components are connected if they have the same id
    private int id[];//(site indexed)
    private int count;// the number of components
    private int size[];//the size of  components (size indexed)
    private boolean isWeighted;// flag to denote whether we are using a weighted QuickUnion
    
    /**
    *Creates 'n' components
    *@param n : the number of sites/nodes
    *@param isWeighted: a boolean value denoting whether we are going to use weighted QuickUnion
    */
    public UnionFind(int n, boolean isWeighted){
        
        if(n <= 1){
            //throw an exception when the specified no of components is <= 1
            throw new IllegalArgumentException("Number of components should be greater than 1");
        }
        
        id = new int[n];
        this.isWeighted = isWeighted;
        count = n;
        
        for(int i = 0; i < n; i++){
            //initialise 'n' components
            //ith component has the id value as i
            id[i] = i;
        }
    
        if(isWeighted){
            size = new int[n];
            //initially, the size of every component will be 1
            for(int i = 0; i < n; i++){
                size[i] = 1;
            }
        }
        
        
    }
    
    /**
    *
    *@return the number of components
    */
    public int count(){
        return count;
    }
    
    /**
    *The find method uses quick-find to get the component name
    *
    *@param p: the node
    */
    public int quickFind(int p){
        
        if(p >= id.length || p < 0){
            //throw an exception when the specified site does not exist
            throw new IllegalArgumentException("The mentioned site does not exist");
        }
        
        return id[p];
    }
    
    /**
    *@return if the two sites are connected or not
    */
    public boolean connected(int p, int q){
        
        if(p >= id.length || p < 0
            || q >= id.length || q < 0){
            //throw an exception when the specified site does not exist
            throw new IllegalArgumentException("The mentioned site does not exist");
        }
        //all connected components must have the same id[] value
        return find(p) == find(q);
    }
    
    /**
    *Merge the two components if the two sites are in different components
    *@param p component
    *@param q component
    */
    public void union(int p, int q){
        int pId = quickFind(p);
        int qId = quickFind(q);
        
        //don't do anything 
        //if p and q are in the same component
        if(pId == qId) return;
        
        for(int i = 0; i < id.length; i++){
            //merge the two components 
            //by changing the id of component match the other component's id
            if(id[i] == pId){
                id[i] = qId;
             }
        }
        //decrement the no of components by 1
        count --;
        
    }
    
    /**
    *An implementation of find used by quickUnion which gets to the root of the component in which the site resides
    */
    public int find(int p){
        //Recursively iterate back to get the root of the site
        //root will be encountered when the node's parent will be itself
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }
    
    
    /**
    *quickUnion unlike union uses "links" which denotes the name of another site in the same component
    *@param p : site p
    *@param q : site q
    */
    public void quickUnion(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        
        if(pRoot == qRoot) return;
        
        //change the root of the site 
        id[pRoot] = qRoot;
        
        count--;
    }
    
    /**
    *weightedUnion merges the tree with the smaller size (if merging is required)
    *This way we are able to cut down costs to almost O(lgN)
    */
    public void weightedUnion(int p, int q){
        
        if(!isWeighted){
            throw new UnsupportedOperationException("Weighted Union operation cannot be performed!"); 
        }
        
        int i = find(p);
        int j = find(q);
        
        if(i == j) return; //already connected
        
        //check for the smaller tree among them
        if(size[i] < size[j]){
            //make the smaller root point to the larger root
            id[i] = j;
            size[j] += size[i];//update the size of the tree
        }
        else{
           //j root is smaller the i
            id[j] = i;
            size[i] += size[j];
            
        }
        
        count--;
    }
    
    
}
package structures;

/**
*
*
*@author: Devesh Shetty
*/
public class UnionFind{
 
    //each component will be identified by an id
    //two components are connected if they have the same id
    private int id[];
    int count;// the number of components
    
    /**
    *Creates 'n' components
    *@param n : the number of sites/nodes
    */
    public UnionFind(int n){
        
        if(n <= 1){
            //throw an exception when the specified no of components is <= 1
            throw new IllegalArgumentException("Number of components should be greater than 1");
        }
        
        id = new int[n];
        
        for(int i = 0; i < n; i++){
            //initialise 'n' components
            //ith component has the id value as i
            id[i] = i;
        }
        
    }
    
    /**
    *Return the number of components
    */
    public int count(){
        return count;
    }
    
    public int find(int p){
        
        if(p >= id.length || p < 0){
            //throw an exception when the specified site does not exist
            throw new IllegalArgumentException("The mentioned site does not exist");
        }
        
        return id[p];
    }
    
    /**
    *@return if the two components are connected or not
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
        int pId = find(p);
        int qId = find(q);
        
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
    
    
}
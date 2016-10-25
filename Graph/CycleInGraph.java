import java.util.*;
//Detects presence of cycle in graph
//works for both undirected also only if there are no parallel edges

class CycleInGraph{
    List<ArrayList<Integer>> adj;
    int nodes;
    boolean visited[];
    CycleInGraph(int nodes)
    {
        this.nodes = nodes;
        visited = new boolean[nodes];
        Arrays.fill(visited,false);
        adj = new ArrayList<ArrayList<Integer>>();    // check
      //  ArrayList<Integer> temp = new ArrayList<Integer>();
     //   Collections.fill(adj,temp);
       for(int i=0;i<nodes;i++)							//NEED THOROUGH CHECK
        {
        	ArrayList<Integer> temp = new ArrayList<Integer>();
        	adj.add(temp);
        }
    }
    void addEdge(int a, int b)
    {
        adj.get(a).add(b);							//BIGGEST BLUNDER
    }
    boolean isCyclic()
    {
       // Iterator i = adj.iterator();
        for(int i=0;i<nodes;i++)							// forgot to mention int
        {
        	boolean parent[] = new boolean[nodes];
        	Arrays.fill(parent, false);
        		if(isCyclicUtil(i,parent))
        			return true;
        }
        return false;
    }
    boolean isCyclicUtil(int i,boolean[] parent)
    {
    	if(!visited[i])
    	{
    	//System.out.print(" "+i);
    	visited[i]=true;
    	parent[i]=true;
        Iterator<Integer> it = adj.get(i).iterator();			// Forgot to mention generic
        while(it.hasNext())
        {
             int vertex = it.next();
             if(parent[vertex]||isCyclicUtil(vertex,parent))	//TIME CONSUMING 
            	 return true;
        }
    	}
    	return false;
        
    }
    public static void main(String []args)
    {
        CycleInGraph g = new CycleInGraph(4);
    g.addEdge(0, 1);
    //g.addEdge(0, 2);
    //g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
   // g.addEdge(3, 3);
    if(g.isCyclic())
    	System.out.println("yes");
    else
    	System.out.println("no");
        
    }
}
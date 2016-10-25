import java.util.*;
//DFS traversal of graph

class DFS{
    List<ArrayList<Integer>> adj;
    int nodes;
    boolean visited[];
    DFS(int nodes)
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
    void DFS()
    {
       // Iterator i = adj.iterator();
        for(int i=0;i<nodes;i++)							// forgot to mention int
        {
        		DFSUtil(i);
        }
    }
    void DFSUtil(int i)
    {
    	if(visited[i])
    		return;
    	System.out.print(" "+i);
    	visited[i]=true;
        Iterator<Integer> it = adj.get(i).iterator();			// Forgot to mention generic
        while(it.hasNext())
        {
             int vertex = it.next();
             DFSUtil(vertex);
        }
    }
    public static void main(String []args)
    {
        DFS g = new DFS(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.DFS();
        
    }
}
//Topological sorting of graph nodes
import java.util.*;
public class Topological{
    LinkedList<Integer> adjList[];
    int nodes;    
    Topological(int totalNodes){
        adjList = new LinkedList[totalNodes];
        for(int i=0;i<totalNodes;i++){
            adjList[i]= new LinkedList<Integer>();
        }
        nodes = totalNodes;
    }
    void addEdge(int from ,int to){
        if(from<0 || from >nodes ||to<0 || to >nodes){
            return;
        }
        adjList[from].offer(to);
    }
    void TopologicalSortUtil(int cur, HashSet<Integer> visited,LinkedList<Integer> stack){
        if(visited.contains(cur))
            return;
        visited.add(cur);
        Integer element=null;
        for(Iterator<Integer> i = adjList[cur].iterator();i.hasNext();){
            element = i.next();
            TopologicalSortUtil(element,visited,stack);
        }
        stack.push(cur);
    }
    void TopologicalSort(){
        HashSet<Integer> visited = new HashSet<Integer>();
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i=0;i<nodes;i++){
            TopologicalSortUtil(i,visited,stack);
        }
        while(!stack.isEmpty()){
            System.out.print(" "+stack.pop());
        }
    }
    public static void main(String args[]){
        Topological g = new Topological(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.TopologicalSort();
    }

}
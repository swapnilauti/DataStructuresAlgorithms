/*
Graph BFS Traversal
*/
import java.util.*;
public class BFS{
    LinkedList<Integer> adjList[];
    int nodes;    
    BFS(int totalNodes){
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
    void BFSUtil(HashSet<Integer> visited,Queue<Integer> q){
        Integer cur = null,temp = null;
        while(!q.isEmpty()){
            cur = q.poll();
            visited.add(cur);
            System.out.print(" "+cur);
            for(Iterator<Integer> i = adjList[cur].iterator();i.hasNext();){
                    temp = i.next();
                    if(!visited.contains(temp))        
                        q.offer(temp);            
            }            
        }
    }
    void BFS(){
        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        //for(int i=0;i<nodes;i++){
        q.offer(2);
            BFSUtil(visited,q);
        //}
    } 
    public static void main(String args[]){
        BFS g = new BFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS();
    }

}
import java.util.*;
//dijkstra's shortest path algorithm
public class Dijkstras{
    int aDijkstrasMat[][];
    int nodes;
    int dist[];
    Dijkstras(int mat[][]){
        aDijkstrasMat = mat;
        nodes = aDijkstrasMat.length;
        dist = new int[nodes];
        Arrays.fill(dist,Integer.MAX_VALUE);
    }
    public int findMin(boolean incVertex[]){
        int min = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i=0;i<nodes;i++){
            if(incVertex[i]==false && dist[i]!=Integer.MAX_VALUE && dist[i]<minDist){
                min = i;
                minDist = dist[i];
            }
        }
        return min;
    }
    public void algo(int source){
        dist[source] = 0;
        boolean incVertex[] = new boolean[nodes];
        int min = 0;
        for(int i=0;i<nodes;i++){
                min = findMin(incVertex);
                if(min == -1)
                 break;
                incVertex[min] = true;                
                for(int j=0;j<nodes;j++){
                    if(incVertex[j]==false &&  aDijkstrasMat[min][j]!=0 && aDijkstrasMat[min][j]+dist[min]<dist[j]){                                
                        dist[j] = aDijkstrasMat[min][j]+dist[min];
                    }
                }
        }        
    }
    public void printDist(){
        for(int i:dist)
            System.out.print(" "+i);
    }
    public static void main(String args[]){
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 0, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 14, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        Dijkstras t = new Dijkstras(graph);
        t.algo(0);
        t.printDist();
    }
    
}
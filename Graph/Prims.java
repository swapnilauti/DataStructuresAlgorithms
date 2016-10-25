import java.util.*;
//Prim's algorithm for minimum spanning tree
public class Prims{
    int aPrimsMat[][];
    int nodes;
    int dist[];
    Prims(int mat[][]){
        aPrimsMat = mat;
        nodes = aPrimsMat.length;
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
        int from[] = new int[nodes];
        from[source] = source;
        boolean incVertex[] = new boolean[nodes];
        int min = 0;
        for(int i=0;i<nodes;i++){
                min = findMin(incVertex);
                if(min == -1)
                 break;
                incVertex[min] = true;                
                for(int j=0;j<nodes;j++){
                    if(incVertex[j]==false &&  aPrimsMat[min][j]!=0 && aPrimsMat[min][j]<dist[j]){                                
                        dist[j] = aPrimsMat[min][j];
                        from[j] = min;
                    }
                }
        }        
      System.out.println("from Matrix");
      for(int i:from)
            System.out.print(" "+i);
      System.out.println();
    }
    public void printDist(){
        for(int i:dist)
            System.out.print(" "+i);
    }
    public static void main(String args[]){
        int graph[][] = new int[][]{{0, 2, 0, 6, 0},
                      {2, 0, 3, 8, 5},
                      {0, 3, 0, 0, 7},
                      {6, 8, 0, 0, 9},
                      {0, 5, 7, 9, 0},
                     };
        Prims t = new Prims(graph);
        t.algo(0);
        t.printDist();
    }
    
}
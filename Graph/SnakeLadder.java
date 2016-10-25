
public class SnakeLadder{
    int moves[];
    int source,destination;
    int nodes;
    int throwsNo[];
    public SnakeLadder(int graph[]){
        moves=graph;
        nodes = graph.length;
        source = 0;
        destination = nodes-1;
        throwsNo = new int[nodes];
    }
    public int minThrowCal(){
        int moveNo =0;
        for(int i=0;i<nodes;i++){
          	if(moves[i]!=-1)
              continue;
            for(int j=1;j<=6;j++){
                if((i+j)>=nodes)
                    break;
                moveNo = moves[i+j]==-1?(i+j):moves[i+j];
                if(throwsNo[moveNo]==0 || (throwsNo[moveNo]>throwsNo[i]+1)){
                    throwsNo[moveNo]=throwsNo[i]+1;
                }                
            }
          System.out.print(" "+throwsNo[i]);
        }
        return throwsNo[nodes-1];
    }
    public static void main(String args[]){
         int N = 30;
         int moves[] = new int[N];
    for (int i = 0; i<N; i++)
        moves[i] = -1;
 
    // Ladders
    moves[2] = 21;
    moves[4] = 7;
    moves[10] = 25;
    moves[19] = 28;
 
    // Snakes
    moves[26] = 0;
    moves[20] = 8;
    moves[16] = 3;
    moves[18] = 6; 
        SnakeLadder obj = new SnakeLadder(moves);
        System.out.println(obj.minThrowCal());
    }    
}
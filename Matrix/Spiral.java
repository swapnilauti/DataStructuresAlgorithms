/*
* Prints a matrix of 'X' and '0' in spiral fashion
* */

package Matrix;

public class Spiral
{
    char arr[][];
    Spiral(int r, int c){

        arr = new char [r][c];
    }
    void fun(int r, int c){
        boolean flag = true;
        for(int i=0,j=0;i<r/2 || j<c/2;i++,j++){
            printRight(i,j,c-j,flag);
            printDown(c-j-1,i+1,r-i,flag);
            printRight(r-i-1,j,c-j-1,flag);
            printDown(j,i+1,r-i-1,flag);
            flag=!flag;
        }
        if(r%2!=0 && c%2!=0){
            arr[r/2][c/2]=(flag?'x':'0');
        }

    }
    void printRight(int x, int startY, int endY, boolean flag){
        for(int i=startY;i<endY;i++){
            arr[x][i]=(flag?'x':'0');
        }
    }
    void printDown(int y, int startX, int endX, boolean flag){
        for(int i=startX;i<endX;i++){
            arr[i][y]=(flag?'x':'0');
        }
    }

    public static void main(String[] args)
    {
        int r =5, c=6;
        Spiral hw = new Spiral(r,c);
        hw.fun(r,c);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(hw.arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}


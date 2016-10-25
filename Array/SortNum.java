public class SortNum{
    int arr[];
    SortNum(int arr[]){
        this.arr=arr;
    }
    public int[] sortFunUtil(int n, int d2){
        int temp[] = new int[arr.length];
        int temp2[] = new int[n];
        for(int i=0;i<arr.length;i++){
            int index = ((arr[i]/d2)%n);
            temp2[index]++;
        }
        for(int i=1;i<n;i++){
            temp2[i]+=temp2[i-1];
        }
        for(int i=arr.length-1;i>=0;i--){
            int index = ((arr[i]/d2)%n);
            temp2[index]--;
            temp[temp2[index]] = arr[i];
        }
        return temp;
    }
    public void sortFun(){
        int n = arr.length;
        arr = sortFunUtil(n,1);
        arr = sortFunUtil(n,n);
    }
    public void printArr(){
        for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
    }
    public static void main(String[] args){
        SortNum obj = new SortNum(new int[]{40, 12, 45, 32, 33, 1, 22});
        obj.sortFun();
        obj.printArr();
        
    }
    
}
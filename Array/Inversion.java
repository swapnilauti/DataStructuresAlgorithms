import java.util.LinkedList;
//count inversions in array
class Inversion{
    int arr[];
    int size;
    Inversion(int arr[]){
        this.arr = arr.clone();
        size = arr.length;
    }
    int mergeSort(int low,int high){
        if(low>=high-1)									//check this condition
            return 0;
        int mid = (low+high)/2;
        int count1= mergeSort(low,mid);
        int count2= mergeSort(mid,high);
        return count1+count2+merge(low,mid,high);
    }
    int merge(int low,int mid,int high){
        int i=low,j=mid,k=0,count=0,length=high-low;
        int temp[] = new int[length];
        while(i<mid && j<high){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
                count+=mid-i;
            }
        }
        while(i<mid){
            temp[k++]=arr[i++];
        }
        while(j<high){
            temp[k++]=arr[j++];
            count+=mid-i;
        }
        for(k=0,i=low;k<length;k++){
            arr[i]=temp[k];
        }
        return count;
    }
    int countInv(){
    	//System.out.println("in countInv size = "+size);
        return mergeSort(0,size);
    }
    public static void main(String[] args){
        Inversion obj = new Inversion(new int[]{5,4,3,2,1});
        System.out.println(obj.countInv());
    }

}
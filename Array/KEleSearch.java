import java.util.*;
public class KEleSearch{
    int arr[];
    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap ;
    KEleSearch(int arr[]){
        this.arr=arr;
    }
    void initHeap(){
        minHeap = new PriorityQueue<Integer>();				//CHECK PRIORITY QUEUE CONSTRUCTORS PROVIDED
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){public int compare(Integer i,Integer j){return j.compareTo(i);}});
    }
    int kSmallest(int k){
        initHeap();
        if(k>arr.length)
            return Integer.MAX_VALUE;
        int i=0;
        while(maxHeap.size()!=k){
            maxHeap.offer(arr[i++]);
        }
        for(;i<arr.length;i++){
            int peak = maxHeap.peek();
            if(arr[i]<peak){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        return maxHeap.poll();        
    }
    int kLargest(int k){
        initHeap();
        if(k>arr.length)
            return Integer.MIN_VALUE;
        int i=0;
        while(minHeap.size()!=k){
            minHeap.offer(arr[i++]);
        }
        for(;i<arr.length;i++){
            int peak = minHeap.peek();
            if(arr[i]>peak){
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        return minHeap.poll();       
    }
    public static void main(String[] args){
        KEleSearch obj = new KEleSearch(new int[]{7, 10, 4, 3, 20, 15});
        System.out.println(" 4th smallest element = "+obj.kSmallest(4));
        System.out.println(" 4th largest element = "+obj.kLargest(4));
    }
}
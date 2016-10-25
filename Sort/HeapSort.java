import java.util.*;
class HeapSort{

    static int a[],size,capacity;
    HeapSort(int []a,int capacity)
    {
        this.a = new int[capacity];
        this.a = a;
        //this.a=Arrays.fill(a,0,6);                         //check
        size=a.length;
        this.capacity=capacity;
        System.out.println("a.length"+this.a.length);
    }
    void swap(int i, int j)
    {
        a[i]+=a[j];
        a[j]=a[i]-a[j];
        a[i]=a[i]-a[j];
    }
    void heapify(int index)
    {
        int left = 2*index +1;
        int right = 2*index +2;
        int min = index;
        if(left<size&&a[min]>a[left])
        {
            min =left;
        }
        if(right<size&&a[min]>a[right])
        {
            min=right;
        }
        if(min!=index)
        {
            swap(min,index);
            heapify(min);
        }
    }
    void sortFun()
    {
        for(int i=(size-1)/2;i>=0;i--)
        {
            heapify(i);
        }
    }
    int pop()
    {
        if(size==0)
            return Integer.MIN_VALUE;
        int pop = a[0];                        //check var name
        if(size!=1)
        {
            a[0]=a[--size];
            heapify(0);
        }
        else
            size=0;
        return pop;
    }
    boolean insert(int key)
    {
        if(size==capacity)
            return false;
        a[size++]=key;
        for(int temp=(size-1)/2,i=size-1;temp>=0&&a[temp]>key;temp--)
        {
            swap(temp,i);
            temp=(temp-1)/2;
            
        }
        return true;
    }
    public static void main(String []args)
    {
        HeapSort h = new HeapSort(new int[]{3,8,6,5,7,2,9},9);
        h.sortFun();
        //System.out.println("min: "+h.pop());
       // h.insert(10);
        while(size!=0)
            System.out.println(h.pop());
        
    }
}

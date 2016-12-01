package Queue;

/**
 * Created by SwapnilSudam on 11/17/2016.
 */
import java.util.*;

class Node{
    int pg;
    Node next,prev;
    Node(int pg){
        this.pg=pg;
        next=prev=null;
    }
}

class Qu{
    Node head,tail;
    public void push(Node node){
        if(head==null){
            head=tail=node;
        }
        else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        System.out.println("Pushed "+node.pg);
    }
    public Node pop(){
        if(head==null){
            return null;
        }
        Node temp = head;
        head=head.next;
        if(head==null){
            tail=null;
        }
        else{
            head.prev=null;
        }
        System.out.println("Popped "+temp.pg);
        return temp;

    }

}

public class Lru{
    Qu q;
    HashMap<Integer,Node> hm = new HashMap<Integer,Node>();
    int size = 0;
    Lru(int size){
        q =new Qu();
        this.size=size;
    }
    public Node request(int n){
        if(hm.size()>=size){
            Node temp = q.pop();
            hm.remove(temp.pg);
        }
        if(!hm.containsKey(n)){
            System.out.println("Cache miss");
            Node temp = new Node(n);
            hm.put(n,temp);
            q.push(temp);
            return temp;
        }
        else{
            Node temp = hm.get(n);
            if(q.tail!=temp){
                if(q.head==temp){
                    q.pop();
                    q.push(temp);
                }
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
            }
            return temp;
        }

    }
    public static void main(String args[]){
        int cachesize=3,n=6;
        Lru obj = new Lru(cachesize);
        for(int i=0;i<n;i++){
            System.out.println("Page Requested "+i);
            obj.request(i);
        }
    }

}
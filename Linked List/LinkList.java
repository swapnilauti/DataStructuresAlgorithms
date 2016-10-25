/*
All basic operations for linked list
*/
public class LinkList{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    Node head;
    boolean isEmpty(){
        if(head==null)
            return true;
        return false;
    }
    void insertNode(int data,int pos){
        Node temp = new Node(data),temp2=head;
        if(isEmpty()){
            head=temp;
            return;
        }
        if(pos<=0){
            temp.next=head;
            head=temp;
            return;
        }
        for(int i=1;i<pos && temp2.next!=null;i++,temp2=temp2.next);
        temp.next=temp2.next;
        temp2.next=temp;
    }
    boolean delNode(int key){
        if(isEmpty())
            return false;
        if(head.data==key){
            head=head.next;
            return true;
        } 
        Node temp=head;
        for(;temp.next!=null && temp.next.data!=key;temp=temp.next);
        if(temp.next!=null){
            temp.next=temp.next.next;
            return true;
        }
        return false;
    }
    boolean swapNodes(int key1, int key2){
        if(key1==key2)
            return false;
        Node temp=null,prev1=null,cur1=null,prev2=null,cur2=null;
        for(cur1=head;cur1!=null && cur1.data!=key1;prev1=cur1,cur1=cur1.next);
        for(cur2=head;cur2!=null && cur2.data!=key2;prev2=cur2,cur2=cur2.next);
        if(cur1==null || cur2==null){
            System.out.println("keys not found");
            return false;
        }
        if(prev1==null){
            prev2.next=cur1;
            head=cur2;            
        }
        else if(prev2==null){
                prev1.next=cur2;
                head=cur1;
        }
        else{
            temp = prev2.next;
            prev2.next=prev1.next;
            prev1.next=temp;            
        }
        temp=cur1.next;
        cur1.next=cur2.next;
        cur2.next=temp; 
        return true;   
    }
    void printLL(){
        for(Node temp=head;temp!=null;temp=temp.next)
            System.out.print("  "+temp.data);
    }
    Node midList(Node head){
        Node slow = head,fast = head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next;
            slow=slow.next;            
            if(fast!=null)
                fast=fast.next;
        }
        return slow;
    }    
    Node mergeSort(Node head){
        if(head==null || head.next==null)
            return head;
        Node mid = midList(head);
        Node head2 = mid.next;
        mid.next=null;
        Node head1 = mergeSort(head);
        head2 = mergeSort(head2);
        return merge(head1,head2);
    }
    Node merge(Node h1, Node h2){
        if(h1==null)
            return h2;
        if(h2==null)
            return h1;
        Node retHead=null,temp=null;
        if(h1.data<=h2.data){
            retHead=h1;   
            h1=h1.next; 
        }   
        else{
            retHead=h2;
            h2=h2.next;
        }
        temp=retHead;
        while(h1!=null && h2!=null){
            if(h1.data<=h2.data){
                temp.next=h1;   
                h1=h1.next; 
            }   
            else{
                temp.next=h2;
                h2=h2.next;
            }
            temp=temp.next;    
        }
        while(h1!=null){
            temp.next=h1;   
            h1=h1.next;
            temp=temp.next;
        }
        while(h2!=null){
            temp.next=h2;   
            h2=h2.next;
            temp=temp.next;
        }
        return retHead;
    }
    void sortLL(){
        if(isEmpty())
            return;
        head=mergeSort(head);
    }
    Node reverseList(Node head){
        if(head==null || head.next==null)
            return head;
        Node temp = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }
    void revLL(){
        if(isEmpty())
            return;
        head = reverseList(head);
    }  
  Node revK(Node head,int k){
        if(head==null||head.next==null)
            return head;
        Node prev=null,next=null,cur = head;
        for(int i = 0;cur!=null && i<k;i++){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }    
        head.next = revK(cur,k);
        return prev;    
    } 
    void reverseK(int k){
        if(isEmpty())
            return;
        head = revK(head,k);
    }
    public static void main(String args[]){
        LinkList obj = new LinkList();
        obj.insertNode(3,0);
        obj.insertNode(5,0);
        obj.insertNode(1,0);
        obj.insertNode(2,0);
       System.out.println("Original List");
        obj.printLL();
      System.out.println("\nAfter Swapping 3 ,2 ");
        obj.swapNodes(3,2);
       
        obj.printLL(); 
        obj.sortLL();
      System.out.println("\nAfter Sorting");
        obj.printLL(); 
        obj.revLL();
        System.out.println("\nAfter Reversing");
        obj.printLL(); 
      	System.out.println("\nAfter Reversing k = 3 ");
        obj.reverseK(3);
        obj.printLL();
    }
}
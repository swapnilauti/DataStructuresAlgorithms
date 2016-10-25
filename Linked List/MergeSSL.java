/*
Merge Sort for Singly linked list
*/
public class MergeSSL{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    public Node head;
    boolean isEmpty(){
        return head==null;
    }
    void insert(int data){
        Node temp = new Node(data);
        if(isEmpty()){
            head=temp;
        }
        else{
            temp.next=head;
            head=temp;
        }
    }
    Node splitMid(Node head){
        Node slow = head,fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    Node mergeSort(Node head1){
        if(head1==null||head1.next==null)
            return head1;
        Node mid=splitMid(head1);
      	Node head2 = mid.next;
        mid.next=null;
        head1=mergeSort(head1);
        head2=mergeSort(head2);
        return merge(head1,head2);
    }
    Node merge(Node n1, Node n2){
        Node head1=null,temp = null;
        if(n1.data<=n2.data){
            head1=n1;
            n1=n1.next;
        }
        else{
            head1=n2;
            n2=n2.next;
        }
        temp=head1; 
        while(n1!=null && n2!=null){
            if(n1.data<=n2.data){
                temp.next=n1;              	
                n1=n1.next;                
            }
            else{
                temp.next=n2;
                n2=n2.next;
            }
          //temp.next.prev=temp;
            temp=temp.next;
        }
        while(n1!=null){
            temp.next=n1;
            n1=n1.next;    
          //temp.next.prev=temp;
            temp=temp.next;
        }
        while(n2!=null){
            temp.next=n2;
            n2=n2.next;    
          //temp.next.prev=temp;
            temp=temp.next;
        }
      	//printDLL(temp);
        return head1;
    }
    void printDLL(Node temp){
        if(isEmpty()){
            return;
        }
        for(;temp!=null;temp=temp.next){
            System.out.print(" "+temp.data);
        }        
      System.out.println();
    }
    void sortDLL(){
        if(!isEmpty()){
            head=mergeSort(head);
        }    
    }
    public static void main(String[] args){
         MergeSSL obj = new MergeSSL();
         obj.insert(0);
         obj.insert(1);
      obj.insert(3);
         
         System.out.println("Before Sorting ");
         obj.printDLL(obj.head);
         obj.sortDLL();
         System.out.println("After Sorting ");
         obj.printDLL(obj.head);
         
    }
}
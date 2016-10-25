class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }    
}
public class SortStack{
    Node top;
    public boolean isEmpty(){
        return top==null;
    }
    public void push(int data){
        Node temp = new Node(data);
        if(!isEmpty()){
            temp.next=top;
        }
        top=temp;
    }
    public Node pop(){
        if(isEmpty())
            return null;
        Node temp = top;
        top=top.next;
        return temp;
    }
    public void sortStack(){
        if(isEmpty())
            return;
        Node temp = pop();
        sortStack();
        sortedInsert(temp); 
    }
    public void sortedInsert(Node ele){
        if(isEmpty()){
            top=ele;
            return;
        }
        if(ele.data<=top.data){
            ele.next=top;
            top=ele;
        }
        else{
            Node temp = pop();
            sortedInsert(ele);
            temp.next=top;
            top=temp;
        }  
    }
    /*public void sortStack(){
        top = sortStackUtil();
    }*/
    public void printStack(){
        while(!isEmpty()){
            System.out.println(pop().data);
        }
    }
    public static void main(String args[]){
        SortStack obj = new SortStack();
        obj.push(5);
        obj.push(2);
        obj.push(1);
        obj.push(3);
        obj.push(4);
        obj.sortStack();
        obj.printStack();
    }
}
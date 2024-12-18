//mainly concerned about removing the lastNode in the linkedList

class LinkedList{
    private Node head;
    private Node tail;
    private int length;

    class Node{
        public int value;
        public Node next;

        Node(int value){
            this.value= value;
        }
    }

    public LinkedList(int value){
        Node newNode= new Node (value);
        head= newNode;
        tail = newNode;
        length =1;
    }

    public void appendList(int value){
        Node newNode = new Node (value);
        if(length==0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next= newNode;
            tail=newNode;
        }
        length+=1;
    }

    public void printList(){
        Node temp=head;
        while(temp !=null){
            System.out.println(" node value " + temp.value);
            temp=temp.next;
        }
    }

    public Node removeLastNode(){
        if(length==0){
            return null;
        }
        Node pre=head;
        Node temp= head;
        while(temp.next!=null) {
            pre=temp;
            temp=temp.next;
        }
        tail= pre;
        tail.next=null;
        length-=1;
        if(length==0){
            head=null;
            tail=null;
        }
        return temp;
    }
}

public class removeLastNode{

    public static void main(String args[]){
        LinkedList myLinkedList = new LinkedList (10);
        
        myLinkedList.appendList(20);
        myLinkedList.printList();
        myLinkedList.appendList(15);
        myLinkedList.printList();


        System.out.println(" Remove Last Node Function" +myLinkedList.removeLastNode().value);

    }

}
// Includes creating a Node, Linked List, and appending New Nodes and printing the linkedList
class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void appendNode(int value){
        Node appendNode = new Node(value);
        if (length ==0){
            head= appendNode;
            tail= appendNode;
        }
        else{
            tail.next=appendNode;
            tail=tail.next;
        }
    }
}

public class createANewNode {
    public static void main(String args[]) {
        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.appendNode(1);
        myLinkedList.printList();
    }
}

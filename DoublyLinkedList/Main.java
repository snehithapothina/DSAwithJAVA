/*
 * This File implements a Doubly Linked List with methods to:
 * 1. Append a node to the end,
 * 2. Prepend a node to the beginning,
 * 3. Insert a node at a specific index,
 * 4. Remove the first node,
 * 5. Remove the last node,
 * 6. Remove a node at a specific index,
 * 7. Get the node based on its index,
 * 8. Set the value of a node at a specific index,
 * 9. Print the linked list.
 */

 class DoublyLinkedList {

    // Head and tail pointers to the doubly linked list
    private Node head;
    private Node tail;
    public int length; // Tracks the length of the linked list

    // Node class representing individual nodes of the doubly linked list
    class Node {
        Node prev; // Reference to the previous node
        Node next; // Reference to the next node
        int value; // Value stored in the node

        public Node(int value) {
            this.value = value;
        }
    }

    // Constructor to initialize the list with a single node
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1; // Initialize length to 1
    }

    // Getter for head node
    public Node getHead() {
        return head;
    }

    // Getter for tail node
    public Node getTail() {
        return tail;
    }

    // Getter for the length of the list
    public int getLength() {
        return length;
    }

    // Prints all node values in the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Prints detailed information about the list, including head, tail, and all node values
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length: " + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    // Appends a new node with the given value to the end of the list
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length += 1;
    }

    // Prepends a new node with the given value to the beginning of the list
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length += 1;
    }

    // Inserts a new node at the specified index with the given value
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node before = get(index - 1); // Node before the target index
        Node after = before.next;    // Node at the target index
        Node newNode = new Node(value);

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;

        length += 1;
        return true;
    }

    // Removes and returns the first node in the list
    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length -= 1;
        return temp;
    }

    // Removes and returns a node at the specified index
    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node temp = get(index); // Node to remove
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;
        length -= 1;
        return temp;
    }

    // Removes and returns the last node in the list
    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length -= 1;
        return temp;
    }

    // Retrieves the node at the specified index
    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp;
        // Optimize traversal by starting from head or tail based on the index
        if (index < length / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    // Updates the value of a node at the specified index
    public boolean set(int index, int value) {
        Node temp = get(index); // Retrieve the node
        if (temp != null) {
            temp.value = value; // Update the value
            return true;
        }
        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList myDLL = new DoublyLinkedList(7);

        // Appending nodes to the list
        myDLL.append(9);
        myDLL.append(2);
        myDLL.append(11);
        myDLL.append(6);
        myDLL.append(16);
        myDLL.append(5);

        System.out.println("Appending the elements:");
        myDLL.printAll();

        // Prepending a node
        myDLL.prepend(1);
        System.out.println("Adding a node at the front:");
        myDLL.printList();

        // Inserting a node at a specific index
        myDLL.insert(2, 18);
        System.out.println("Inserting a Node:");
        myDLL.printList();

        // Removing the first node
        myDLL.removeFirst();
        System.out.println("Removing Node at the front of the list:");
        myDLL.printList();

        // Removing a node at a specific index
        myDLL.remove(3);
        System.out.println("Removing a Node:");
        myDLL.printList();

        // Removing the last node
        System.out.println("Removing last Node:");
        System.out.println(myDLL.removeLast().value);

        // Getting and updating a node at a specific index
        System.out.println("Node at Index 2: " + myDLL.get(2).value);
        System.out.println("Updating the value of the Node at Index 2: " + myDLL.set(2, 7));
        System.out.println("Updated List:");
        myDLL.printList();
    }
}

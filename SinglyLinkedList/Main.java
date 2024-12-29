/*
 * This File implements a LinkedList with methods to:
 * 1. Append a node to the end,
 * 2. Prepend a node to the beginning,
 * 3. Insert a node at a specific index,
 * 4. Remove the first node,
 * 5. Remove the last node,
 * 6. Remove a node at a specific index,
 * 7. Get the node based on its index,
 * 8. Set the value of a node at a specific index,
 * 9. Reverse the linked list,
 * 10. Print the linked list.
 */
class LinkedList {

    // Inner Node class represents each node in the linked list
    private Node head;  // The first node in the list
    private Node tail;  // The last node in the list
    private int length; // The number of nodes in the list

    // Node class for creating linked list nodes
    class Node {
        int value;      // The value of the node
        Node next;      // The reference to the next node

        Node(int value) {
            this.value = value;
        }
    }

    // Constructor initializes the linked list with a single node
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1; // Only one node exists initially
    }

    // Getter for the head node
    public Node getHead() {
        return head;
    }

    // Getter for the tail node
    public Node getTail() {
        return tail;
    }

    // Getter for the length of the linked list
    public int getLength() {
        return length;
    }

    // Method to print the values of all nodes in the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value); // Print the value of each node
            temp = temp.next;               // Move to the next node
        }
    }

    // Method to print the full status of the linked list (head, tail, length, and nodes)
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    // Method to empty the linked list (set head and tail to null, and length to 0)
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    // Method to append a new node with the given value to the end of the list
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode; // If the list is empty, set head and tail to the new node
            tail = newNode;
        } else {
            tail.next = newNode;  // Set the last node's next reference to the new node
            tail = newNode;        // Update the tail to the new node
        }
        length++;  // Increment the length of the list
    }

    // Method to prepend a new node with the given value to the beginning of the list
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;  // If the list is empty, set head and tail to the new node
            tail = newNode;
        } else {
            newNode.next = head;  // Link the new node to the current head
            head = newNode;       // Set the new node as the head
        }
        length++;  // Increment the length of the list
    }

    // Method to insert a new node with the given value at a specified index
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false; // Check for invalid index
        if (index == 0) {
            prepend(value);  // If inserting at index 0, prepend the node
            return true;
        }
        if (index == length) {
            append(value);   // If inserting at the end, append the node
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1); // Get the node just before the insertion index
        newNode.next = temp.next;   // Link the new node to the next node
        temp.next = newNode;        // Link the previous node to the new node
        length++;  // Increment the length of the list
        return true;
    }

    // Method to remove the first node in the list
    public Node removeFirst() {
        if (length == 0) return null;  // Return null if the list is empty
        Node temp = head;              // Store the current head
        head = head.next;              // Move the head to the next node
        temp.next = null;              // Disconnect the removed node from the list
        length--;  // Decrement the length of the list
        if (length == 0) {
            tail = null;  // If the list is empty, set the tail to null
        }
        return temp;  // Return the removed node
    }

    // Method to remove the last node in the list
    public Node removeLast() {
        if (length == 0) return null;  // Return null if the list is empty
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {    // Traverse the list to find the last node
            pre = temp;
            temp = temp.next;
        }
        tail = pre;         // Set the second-to-last node as the tail
        tail.next = null;   // Set the next reference of the tail to null
        length--;  // Decrement the length of the list
        if (length == 0) {
            head = null;   // If the list is empty, set the head to null
            tail = null;   // Set the tail to null as well
        }
        return temp;  // Return the removed node
    }

    // Method to remove a node at a specific index
    public Node remove(int index) {
        if (index < 0 || index >= length) return null; // Return null for invalid index
        if (index == 0) return removeFirst();  // If removing the first node, call removeFirst
        if (index == length - 1) return removeLast();  // If removing the last node, call removeLast()

        Node prev = get(index - 1);  // Get the node before the node to be removed
        Node temp = prev.next;        // Get the node to be removed
        prev.next = temp.next;        // Skip the node to be removed by linking previous node to the next
        temp.next = null;             // Disconnect the removed node from the list
        length--;  // Decrement the length of the list
        return temp;  // Return the removed node
    }

    // Method to get the node at a specific index
    public Node get(int index) {
        if (index < 0 || index >= length) return null;  // Return null for invalid index
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;  // Traverse to the desired index
        }
        return temp;  // Return the node at the specified index
    }

    // Method to set the value of the node at a specific index
    public boolean set(int index, int value) {
        Node temp = get(index);  // Get the node at the specified index
        if (temp != null) {
            temp.value = value;  // Update the value of the node
            return true;         // Return true if the value is updated successfully
        }
        return false;  // Return false if the node is not found
    }

    // Method to reverse the linked list
    public void reverse() {
        Node temp = head;
        head = tail;  // Swap head and tail
        tail = temp;
        Node before = null;
        Node after = temp.next;

        for(int i = 0; i < length; i++) {
            after = temp.next;   // Store the next node
            temp.next = before;  // Reverse the direction of the current node
            before = temp;       // Move the 'before' pointer forward
            temp = after;        // Move to the next node
        }
    }
}

// Main class to test the LinkedList implementation
public class Main {

    public static void main(String[] args) {

        // Creating a linked list and adding elements
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(6);

        System.out.println("Appending the elements:");
        myLinkedList.printList();

        // Prepending a node to the front
        myLinkedList.prepend(8);
        System.out.println("Adding a node at the front:");
        myLinkedList.printList();

        // Inserting a node at a specific index
        myLinkedList.insert(2, 10);
        System.out.println("Inserting a Node:");
        myLinkedList.printList();

        // Removing the first node
        myLinkedList.removeFirst();
        System.out.println("Removing Node at the front of the list:");
        myLinkedList.printList();

        // Removing a node at a specific index
        myLinkedList.remove(3);
        System.out.println("Removing a Node :");
        myLinkedList.printList();

        // Removing the last node
        myLinkedList.removeLast();
        System.out.println("Removing last Node :");
        myLinkedList.printList();

        // Getting and updating a node at a specific index
        System.out.println("Node at Index 3: " + myLinkedList.get(3).value);
        System.out.println("Updating the value of the Node at Index 3: " + myLinkedList.set(3, 7));
        System.out.println("Updated List:");
        myLinkedList.printList();

        // Reversing the list and printing the result
        System.out.println("Reversing the list:");
        myLinkedList.reverse();
        myLinkedList.printList();
    }
}

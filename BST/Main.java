/*
 * This file contains the operations related to BST
 * 1. Insert
 * 2.Lookup
 */

class BinarySearchTree{
    Node root;
    class Node{
        int value;
        Node right;
        Node left;

        Node(int value){
            this.value=value;
        }
    }

    public boolean insert(int value){
        Node newNode=new Node(value);
        if(root==null){
            root=newNode;
            return true;
        }
        Node temp=root;
        while(true){
            if(temp.value==newNode.value){
                return false;
            }
            if(temp.value>newNode.value){
                if(temp.left==null){
                    temp.left=newNode;
                    return true;
                }
                temp=temp.left;
            }
            if(temp.value<newNode.value){
                if(temp.right==null){
                    temp.right=newNode;
                    return true;
                }
                temp=temp.right;
            }

        }
    }

    public boolean lookup(int value){
        if(root==null){
            return false;
        }
        Node temp=root;
        while(temp!=null){
            if(temp.value==value){
                return true;
            }
            if(temp.value>value){
                temp=temp.left;
            }
            if(temp.value<value){
                temp=temp.right;
            }
        }
        return false;
    }

}



public class Main{
    public static void main(String args[]){
        BinarySearchTree BST=new BinarySearchTree();
        BST.insert(10);
        BST.insert(0);
        BST.insert(25);
        BST.insert(-2);
        BST.insert(15);
        BST.insert(21);
        System.out.println(BST.root.right.left.right.value);
        System.out.println("Is node 15 in BST? "+ BST.lookup(15));
        System.out.println("Is node 1 in BST? "+ BST.lookup(1));


    }



}
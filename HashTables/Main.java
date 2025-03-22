/*getting and setting a hash item - O(1) */

import java.util.ArrayList;

class hashtables{
    private int size=7;
    private Node[] dataMap;

    class Node{
        String key;
        int value;
        Node next;

        Node(String key, int value){
            this.key=key;
            this.value=value;
        }
    }
    public hashtables(){
        dataMap=new Node[size];
    }

    public void printTable(){
        for (int i=0;i<dataMap.length;i++){
            System.out.println(i+": ");
            Node temp=dataMap[i];
            while(temp!=null){
                System.out.println(" {"+temp.key+ "= " + temp.value + "}");
                temp=temp.next;
            }
        }
    }

    private int hash(String key){
        int hash=0;
        char[] keyChars=key.toCharArray();
        for(int i=0;i<keyChars.length;i++){
            int asciiValue=keyChars[i];
            hash=(hash+asciiValue*23)%dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index=hash(key);
        Node newNode=new Node(key,value);
        if(dataMap[index]==null){
            dataMap[index]=newNode;
        }
        else{
            Node temp=dataMap[index];
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }

    }

    public int get(String key){
        int index=hash(key);
        Node temp=dataMap[index];
        while(temp!=null){
            if(temp.key==key) return temp.value;
            temp=temp.next;
        }
        return 0;
    }

    public ArrayList keys(){
        ArrayList<String> allKeys=new ArrayList<>();
        for(int i=0;i<dataMap.length;i++){
            Node temp=dataMap[i];
            while(temp!=null){
                allKeys.add(temp.key);
                temp=temp.next;
            }
        }
        return allKeys;
    }

}

public class Main {
    public static void main(String args[]){
hashtables HashTable= new hashtables();
HashTable.set("nails",100);
HashTable.set("tile",10);
HashTable.set("Snehitha",99);
HashTable.printTable();
System.out.println(HashTable.get("Snehitha"));
System.out.println(HashTable.keys());


    }
    
}

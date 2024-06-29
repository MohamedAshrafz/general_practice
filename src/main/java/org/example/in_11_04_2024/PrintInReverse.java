package org.example.in_11_04_2024;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

public class PrintInReverse {

    public static void main(String[] args) {
        SinglyLinkedListNode n1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode n2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode n3 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode n4 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode n5 = new SinglyLinkedListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        SinglyLinkedListNode chainNode = n1;
        while (chainNode != null){
            System.out.println(chainNode.data);
            chainNode = chainNode.next;
        }
        reversePrint(n1);
    }

    public static void reversePrint(SinglyLinkedListNode llist) {
        SinglyLinkedListNode preNode = null;
        SinglyLinkedListNode chainNode = llist;
        SinglyLinkedListNode nextNode;


        while (chainNode != null) {
            nextNode = chainNode.next;

            chainNode.next = preNode;

            preNode = chainNode;
            chainNode = nextNode;
        }
        chainNode = preNode;

        while (chainNode != null){
            System.out.println(chainNode.data);
            chainNode = chainNode.next;
        }
    }

    class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    class SinglyLinkedListPrintHelper {
        public static void printList(SinglyLinkedListNode node, String sep) {
            while (node != null) {
                System.out.print(node.data);

                node = node.next;

                if (node != null) {
                    System.out.print(sep);
                }
            }
        }
    }

}

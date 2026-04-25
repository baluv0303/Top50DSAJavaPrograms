package TopSDETInterviewQuestions.src.LinkedLists;

import java.util.ArrayList;
import java.util.Collections;

public class MergeKSortedLists {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        // 🔹 Create List 1: 1 -> 4 -> 5
        Node l1 = new Node(1);
        l1.next = new Node(4);
        l1.next.next = new Node(5);

        // 🔹 Create List 2: 1 -> 3 -> 4
        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        // 🔹 Create List 3: 2 -> 6
        Node l3 = new Node(2);
        l3.next = new Node(6);

        // Array of lists
        Node[] lists = {l1, l2, l3};

        // Call function
        Node result = mergeKSortedListsBrute(lists);

        // Print result
        System.out.print("Merged List: ");
        printList(result);
    }


    public static Node mergeKSortedListsBrute(Node[] lists){
        ArrayList<Integer> values = new ArrayList<>();

        for (Node head : lists){
            while (head != null){
                values.add(head.data);
                head= head.next;
            }
        }

        Collections.sort(values);

        Node dummy = new Node(-1);
        Node temp = dummy;
        for(int val : values){
            temp.next = new Node(val);
            temp = temp.next;

        }
        return dummy;
    }

    // Utility to print linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}


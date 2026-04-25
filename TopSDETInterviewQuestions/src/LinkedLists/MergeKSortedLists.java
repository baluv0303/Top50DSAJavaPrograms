package TopSDETInterviewQuestions.src.LinkedLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

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
        Node resultMinHeap= mergeKListMinHeap(lists);
        Node resultSeq= mergeKListSequentialMerge(lists);
        Node result = mergeKSortedListsBrute(lists);

        // Print result
        System.out.print("Merged List: ");
        printList(resultMinHeap);
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

    public static Node mergeKListSequentialMerge(Node[] lists){

        Node result = null;

        for(Node list : lists){
            result = mergeTwoLists(result, list);
        }
        return result;
        //Complexity
        //Time = O(N*K) k= number of list
        //space = O(1)

    }

    public static Node mergeTwoLists(Node l1, Node l2){
        Node dummy = new Node(-1);
        Node tail = dummy;
        while (l1 != null && l2 != null){
            if(l1.data < l2.data){
                tail.next = l1;
                l1= l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1!= null) ? l1 : l2;
        return dummy.next;

    }

    public static Node mergeKListMinHeap(Node[] lists){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data - b.data);

        for(Node head : lists){
            if(head != null){
                pq.offer(head);
            }
        }

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (!pq.isEmpty()){
            Node minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;

            if(minNode.next != null){
                minNode= minNode.next;
                pq.offer(minNode);
            }
        }
        return dummy.next;
        //Approach: “Push heads → Pop smallest → Push next”
        //1. Add first nodes
        // 2. Remove smallest
        //3. Add its next
        //Complexity
        //Time = O(N log K)
        //Space = O(k)

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


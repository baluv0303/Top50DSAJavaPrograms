package TopSDETInterviewQuestions.src.LinkedLists;

import java.util.HashSet;

public class DetectCycleInLinkedList {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;

        }
    }

    public static void main(String[] args) {

        // 🔹 Case 1: No Cycle
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        System.out.println("Cycle present (No Cycle case): " + hasCycleBrute(head1));
        System.out.println("Cycle present (No Cycle case): " + hasCycleFlyodsApproach(head1));

        // 🔹 Case 2: With Cycle
        Node head2 = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        head2.next = second;
        second.next = third;
        third.next = fourth;

        // 🔁 Creating cycle: 40 -> 20
        fourth.next = second;

        System.out.println("Cycle present (Cycle case): " + hasCycleBrute(head2));
        System.out.println("Cycle present (Cycle case): " + hasCycleFlyodsApproach(head2));

    }


    public static boolean hasCycleBrute(Node head){
        HashSet<Node> visitedNodes = new HashSet<>();
        Node temp = head;

        while (temp != null){
            if(visitedNodes.contains(temp)){
                return true;
            }
            visitedNodes.add(temp);
            temp = temp.next;
        }
        return false;
    }

    public static boolean hasCycleFlyodsApproach(Node head){
        Node fast = head, slow = head;

        while (fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}

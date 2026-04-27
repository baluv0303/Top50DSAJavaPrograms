package TopSDETInterviewQuestions.src.LinkedLists;

import java.util.Stack;

public class ReverseLinkedList {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;

        }
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Printing original list");
        printList(head);

        System.out.println("Printing reversed list from bruteforce");
        printList(reverseBruteforce(head));

    }

    public static Node reverseBruteforce(Node head){
        if (head == null) return null;
        Stack<Integer> st = new Stack<>();
        Node temp = head;

        while (temp != null){
            st.push(temp.data);
            temp= temp.next;
        }

        temp = head;

        while (temp != null){
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;

        //Time = O(n)
        //Space = O(n)

    }

    public static Node reverseLinkedList(Node head){
        Node cur = head, prev = null, next;
        while (cur!=null){
            next = cur.next;
            cur.next =prev;
            prev =cur;
            cur = next;
        }
        return prev;

        //Time complexity = O(n);
        //Space complexity = O(1);

    }

    public static void printList(Node head){
        Node temp=head;
        while (temp!= null){
            System.out.print(temp.data + (temp.next != null ? "->" : ""));
            temp= temp.next;
        }
        System.out.println();
    }

}

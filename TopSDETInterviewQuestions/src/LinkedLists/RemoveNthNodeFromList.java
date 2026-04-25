package TopSDETInterviewQuestions.src.LinkedLists;

public class RemoveNthNodeFromList {

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int n = 2;

        System.out.println("Printing original list");
//        head = removeNthNodeFromListBrute(head,n);
        head = removeNthNodeFromListTwoPointer(head, n);

        Node temp = head;

        while (temp != null){
            System.out.print(temp.data+ "->");
            temp= temp.next;
        }


    }

    public static Node removeNthNodeFromListTwoPointer(Node head, int n){
        Node dummy = new Node(-1);
        dummy.next = head;
        Node fast = dummy.next;
        Node slow = dummy.next;

        //move fast to n+1 steps
        for(int i=0; i<= n ; i++){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
//        ⏱ Complexity
//        Time: O(n)
//        Space: O(1)
//        💡 Idea
//        Move fast n+1 steps ahead
//        Then move both until fast reaches end
//        slow lands just before target

    }

    public static Node removeNthNodeFromListBrute(Node head, int n){
        int length = 0;
        Node temp = head;
        while (temp!= null){
            length++;
            temp = temp.next;
        }
        if(n==length) return head.next;
        temp = head;

        for(int i=1; i< length - n - 1; i++){
            temp = temp.next;
        }
        temp.next= temp.next.next;
        return head;

//        ⏱ Complexity
//        Time: O(n)
//        Space: O(1)
//        💡 Idea
//        Count total length
//        Remove (length - n)th node from start
    }


}

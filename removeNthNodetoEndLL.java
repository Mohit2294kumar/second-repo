// Remove Nth Node from End of List: Write a function to remove the Nth node from the start/end of a linked list.
public class removeNthNodetoEndLL{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node removeNthFromEnd(Node head, int n) {
        if(head == null){
            return null;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node slow = dummy;
        Node fast = dummy;
        for(int i = 1; i <= n + 1; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node removed = removeNthFromEnd(head, 2);
        while(removed != null){
            System.out.print(removed.data+" ");
            removed = removed.next;
        }
    }
}
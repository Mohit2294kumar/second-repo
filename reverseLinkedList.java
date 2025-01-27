// Reverse a Linked List: Write a function to reverse a singly linked list.
public class reverseLinkedList{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node reversed = reverseList(head);
        while(reversed != null){
            System.out.print(reversed.data+" ");
            reversed = reversed.next;
        }
    }
}

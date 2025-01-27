// Detect a Cycle in a Linked List: Write a function to detect if a cycle exists in a linked list.
public class detectCycleLL{
    public static boolean hasCycle(Node head) {
        if(head == null || head.next == null){
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;
        System.out.println(hasCycle(head));
    }
}
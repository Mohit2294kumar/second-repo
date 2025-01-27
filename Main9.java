// Merge Two Sorted Linked Lists: Write a function to merge two sorted linked lists into one sorted linked list.
public class mergeTwoSortLL{
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;
        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null){
            current.next = l1;
        }
        if(l2 != null){
            current.next = l2;
        }
        return dummy.next;
    }
    public static void main(String[] args){
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(4);
        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);
        Node merged = mergeTwoLists(l1, l2);
        while(merged != null){
            System.out.println(merged.data);
            merged = merged.next;
        }
    }
}
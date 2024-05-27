public class PartitionListOnPivot {


    static Node partition(Node head, int x) {


        Node lessHead = new Node(-1);
        Node lessTail = lessHead;

        Node equalHead = new Node(-1);
        Node equalTail = equalHead;

        Node greaterHead = new Node(-1);
        Node greaterTail = greaterHead;


        Node curr = head;
        while (curr != null) {

            if (curr.data < x) {
                lessTail.next = curr;
                lessTail = lessTail.next;
            } else if (curr.data == x) {
                equalTail.next = curr;
                equalTail = equalTail.next;
            } else {
                greaterTail.next = curr;
                greaterTail = greaterTail.next;
            }
            curr = curr.next;
        }

        equalTail.next = greaterHead.next;
        lessTail.next = equalHead.next;
        greaterTail.next = null;
        return lessHead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(5);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        Node pivot = partition(head, 3);
        Node curr = pivot;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

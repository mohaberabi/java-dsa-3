public class MergeSort {


    static Node mergeSort(Node head) {
        if (head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node head2 = mid.next;
        mid.next = null;

        Node sortedHead1 = mergeSort(head);
        Node sortedHead2 = mergeSort(head2);

        return merge(sortedHead1, sortedHead2);

    }

    static Node merge(Node a, Node b) {

        Node head = new Node(-1);
        Node tail = head;


        while (a != null && b != null) {
            if (a.data < b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }


        while (a != null) {
            tail.next = a;
            tail = tail.next;
            a = a.next;

        }
        while (b != null) {
            tail.next = b;
            tail = tail.next;
            b = b.next;
        }
        return head.next;
    }

    static Node getMid(Node head) {


        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node temp = head;
        temp.next = new Node(10);
        temp = temp.next;
        temp.next = new Node(5);
        temp = temp.next;
        temp.next = new Node(20);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;


        Node curr = mergeSort(head);
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

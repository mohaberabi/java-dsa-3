public class ReverseSubListOfLinkedList {


    static Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {

            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node reverseSubList(Node head, int start, int end) {

        Node curr = head;

        int i = 0;

        Node unlink = null;
        Node tail = null;


        while (i < start) {
            curr = curr.next;
            i++;
        }

        while (curr != null && i < end) {
            if (unlink == null) {
                unlink = curr;
                tail = unlink;
            } else {
                tail.next = curr;
                tail = tail.next;
            }
            i++;
        }

        Node unlinkNext = null;
        if (tail != null) {
            unlinkNext = tail.next;
        }

        curr = head;

        while (curr.next != unlink) {
            curr = curr.next;
        }
        curr.next = null;
        Node unlinkReverse = reverse(unlink);

        Node unlinkTail = unlinkReverse;
        while (unlinkTail.next != null) {
            unlinkTail = unlinkTail.next;
        }
        unlinkTail.next = unlinkNext;
        head.next = unlinkReverse;
        return head;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(5);
        temp = temp.next;
        temp.next = new Node(6);
        temp = temp.next;

        Node rev = reverseSubList(head, 2, 4);

        Node curr = rev;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

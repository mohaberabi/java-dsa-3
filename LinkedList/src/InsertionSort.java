public class InsertionSort {
    static Node head;
    static Node sorted;

    static void insertionSort(Node headref) {
        sorted = null;
        Node current = headref;
        while (current != null) {
            Node next = current.next;
            sortedInsert(current);
            current = next;
        }
        head = sorted;
    }


    static void sortedInsert(Node newnode) {
        if (sorted == null || sorted.data >= newnode.data) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            Node current = sorted;
            while (current.next != null && current.next.data < newnode.data) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
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
        insertionSort(head);
        Node curr = sorted;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicatesFromSortedLinkedList {


    static Node removeDuplicatesFromSortedLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }


        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;

        Node curr = head;

        while (curr != null) {
            while (curr.next != null && prev.next.data == curr.next.data) {
                curr = curr.next;
            }
            if (prev.next == curr) {
                prev = prev.next;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    static Node removeDuplicatesHashing(Node head) {
        if (head == null || head.next == null) {
            return head;
        }


        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Node curr = head; curr != null; curr = curr.next) {

            map.put(curr.data, map.getOrDefault(curr.data, 0) + 1);

        }


        Node dummy = new Node(-1);
        Node tail = dummy;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {

            if (e.getValue() == 1) {
                tail.next = new Node(e.getKey());
                tail = tail.next;
            }


        }

        return dummy.next;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        temp.next = new Node(1);
        temp = temp.next;
        temp.next = new Node(1);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        Node removed = removeDuplicatesHashing(head);

        Node curr = removed;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

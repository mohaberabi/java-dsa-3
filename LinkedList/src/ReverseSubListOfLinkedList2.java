import java.util.ArrayList;

public class ReverseSubListOfLinkedList2 {


    static Node reverseSubList(Node head, int i, int j) {

        ArrayList<Integer> al = new ArrayList<>();

        Node curr = head;
        while (curr != null) {
            al.add(curr.data);
            curr = curr.next;
        }

        int low = i - 1;
        int high = j - 1;

        while (low < high) {

            int temp = al.get(low);
            al.set(low, al.get(high));
            al.set(high, temp);
            low++;
            high--;
        }

        Node res = new Node(-1);
        Node tail = res;
        for (int x : al) {
            tail.next = new Node(x);
            tail = tail.next;
        }
        return res.next;
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

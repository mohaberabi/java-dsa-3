import org.w3c.dom.Node;

import java.util.PriorityQueue;

public class FlatNode implements Comparable<FlatNode> {


    int data;
    FlatNode next;
    FlatNode bottom;


    public FlatNode(int d) {
        this.data = d;
        next = null;
        bottom = null;
    }

    @Override
    public int compareTo(FlatNode o) {
        return data - o.data;
    }


    public static FlatNode flattenList(FlatNode head) {


        PriorityQueue<FlatNode> pq = new PriorityQueue<>();


        while (head != null) {
            pq.add(head);
            head = head.next;
        }

        FlatNode newHead = new FlatNode(-1);

        FlatNode tail = newHead;
        while (!pq.isEmpty()) {
            FlatNode poll = pq.poll();
            tail.bottom = poll;
            tail = tail.bottom;
            if (poll.bottom != null) {
                pq.add(poll.bottom);
            }
        }

        return newHead.bottom;
    }

    public static void main(String[] args) {
        FlatNode head = new FlatNode(5);
        FlatNode temp = head;
        FlatNode bt = head;

        bt.bottom = new FlatNode(7);
        bt.bottom.bottom = new FlatNode(8);
        bt.bottom.bottom.bottom = new FlatNode(30);

        temp.next = new FlatNode(10);
        temp = temp.next;

        bt = temp;
        bt.bottom = new FlatNode(20);

        temp.next = new FlatNode(19);
        temp = temp.next;

        bt = temp;
        bt.bottom = new FlatNode(22);
        bt.bottom.bottom = new FlatNode(50);

        temp.next = new FlatNode(28);
        temp = temp.next;

        bt = temp;
        bt.bottom = new FlatNode(35);
        bt.bottom.bottom = new FlatNode(40);
        bt.bottom.bottom.bottom = new FlatNode(45);

        FlatNode flat = flattenList(head);
        while (flat != null) {
            System.out.print(flat.data + " ");
            flat = flat.bottom;
        }
    }
}

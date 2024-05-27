import java.util.ArrayList;

public class SortedLinkedListToBst {


    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;


        public TreeNode(int d) {
            data = d;
            left = null;
            right = null;
        }
    }


    static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static TreeNode fromSortedLinkedList(Node head) {

        ArrayList<Integer> inOrderTraversal = new ArrayList<>();

        while (head != null) {
            inOrderTraversal.add(head.data);
            head = head.next;
        }

        for (int x : inOrderTraversal) {
            System.out.print(x + " ");
        }

        TreeNode root = buildTree(inOrderTraversal, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }


    static int index = 0;

    static TreeNode buildTree(ArrayList<Integer> inOrder, int min, int max) {

        if (index == inOrder.size()) {
            return null;
        }
        int current = inOrder.get(index);
        if (current < min || current > max) {
            return null;
        }
        TreeNode root = new TreeNode(current);

        index++;
        root.left = buildTree(inOrder, min, current - 1);
        root.right = buildTree(inOrder, current + 1, max);
        return root;
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
        temp.next = new Node(7);
        temp = temp.next;

        TreeNode root = fromSortedLinkedList(head);

        preOrderTraversal(root);
    }
}

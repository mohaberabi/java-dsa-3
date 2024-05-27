import java.util.ArrayList;

public class SortedLinkedListToBalancedBST {


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


//    static TreeNode buildTreeFromSortedLinkedList(Node head) {
//
//
//        int n = 0;
//
//
//        Node curr = head;
//        while (curr != null) {
//
//            n++;
//            curr = curr.next;
//        }
//
//
//        TreeNode root = buildUtil(n, head);
//
//        return root;
//
//    }


    static TreeNode convertToBstUtil(ArrayList<Integer> list, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = start + (end - start) / 2;
        if ((end - start) % 2 != 0) {
            mid = mid + 1;
        }
        int data = list.get(mid);

        TreeNode root = new TreeNode(data);

        TreeNode left = convertToBstUtil(list, start, mid - 1);
        TreeNode right = convertToBstUtil(list, mid + 1, end);

        root.left = left;
        root.right = right;
        return root;
    }


    static TreeNode convertToBst(Node root) {

        ArrayList<Integer> al = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            al.add(curr.data);
            curr = curr.next;
        }
        return convertToBstUtil(al, 0, al.size() - 1);
    }

//    static TreeNode buildUtil(int n, Node head) {
//
//
//        if (n <= 0) {
//            return null;
//        }
//
//
//        TreeNode left = buildUtil(n / 2, head);
//
//
//        TreeNode root = new TreeNode(head.data);
//        root.left = left;
//        head = head.next;
//
//        root.right = buildUtil(n - n / 2 - 1, head);
//
//
//        return root;
//
//    }


    static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
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

        TreeNode root = convertToBst(head);

        preOrderTraversal(root);
    }
}

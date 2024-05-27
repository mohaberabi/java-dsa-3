package Advanced;

public class TwoStackOneArray {


    private int top1;
    private int top2;
    private int capacity;

    private int[] arr;

    public TwoStackOneArray(int c) {


        arr = new int[c];
        capacity = c;
        top1 = -1;
        top2 = c;

    }


    private boolean isFull() {
        return top1 == top2 - 1;
    }


    int firstSize() {
        return top1 + 1;
    }

    int secondSize() {
        return capacity - top2;
    }


    void push1(int x) {


        if (isFull()) {
            return;
        }
        arr[++top1] = x;

    }


    boolean isEmpty(int n) {
        if (n == 0) {
            return top1 == -1;
        } else {
            return top2 == capacity;
        }
    }

    void push2(int x) {
        if (isFull()) {
            return;
        }
        arr[--top2] = x;
    }

    int pop2() {
        if (isEmpty(1)) {
            return -1;
        }
        int pop = arr[top2];
        top2++;
        return pop;
    }

    int pop1() {
        if (isEmpty(0)) {
            return -1;
        }
        int pop = arr[top1];
        top1--;
        return pop;
    }


}

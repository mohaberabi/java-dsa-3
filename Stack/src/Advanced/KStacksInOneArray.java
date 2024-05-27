package Advanced;

import java.util.Arrays;

public class KStacksInOneArray {


    private int k;
    private int n;

    private int[] arr;

    private int[] next;

    private int[] tops;

    private int freeTop;


    public KStacksInOneArray(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        next = new int[n];

        tops = new int[k];
        Arrays.fill(tops, -1);
        freeTop = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    public void push(int x, int stackNo) {

        if (isFull()) {
            return;
        }
        int i = freeTop;
        freeTop = next[i];
        next[i] = tops[stackNo];
        tops[stackNo] = i;
        arr[i] = x;

    }


    public boolean isEmpty(int stackNo) {

        return tops[stackNo] == -1;
    }

    private boolean isFull() {
        return freeTop == -1;
    }

    public int pop(int stackNo) {
        if (isEmpty(stackNo)) {
            return -1;
        }
        int i = tops[stackNo];
        tops[stackNo] = next[i];
        next[i] = freeTop;
        freeTop = i;
        return arr[i];

    }

}

package dsalgo.tree.segment;

public class SegmentTree {

    private int[] tree;
    private int[] input;
    private int n;


    public SegmentTree(int[] arr) {
        this.input = arr;
        this.n = arr.length;

        int e = getSegmentSize(n);
        this.tree = new int[e];
        construct(0, n - 1, 0);

    }


    public void update(int newValue, int index) {
        int diff = newValue - input[index];
        input[index] = newValue;
        update(0, n - 1, diff, index, 0);
    }

    private void update(int lo, int hi, int diff, int index, int position) {
        if (index < lo || index > hi) {
            return;
        }
        tree[position] += diff;
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        update(lo, mid, diff, index, leftOf(position));
        update(mid + 1, hi, diff, index, rightOf(position));
    }

    public int getSum(int queryStart, int queryEnd) {
        return getSum(0, n - 1, queryStart, queryEnd, 0);
    }

    private int getSum(int lo, int hi, int queryStart, int queryEnd, int position) {
        // total overlap
        if (queryStart <= lo && queryEnd >= hi) {
            return tree[position];
        }
        // no overlap
        if (queryStart > hi || queryEnd < lo) {
            return 0;
        }
        int mid = (lo + hi) / 2;
        // partial overlap
        return getSum(lo, mid, queryStart, queryEnd, leftOf(position))
                + getSum(mid + 1, hi, queryStart, queryEnd, rightOf(position));
    }

    private void construct(int lo, int hi, int position) {
        if (lo == hi) {
            tree[position] = input[lo];
            return;
        }
        int mid = (lo + hi) / 2;
        construct(lo, mid, leftOf(position));
        construct(mid + 1, hi, rightOf(position));
        tree[position] = tree[leftOf(position)] + tree[rightOf(position)];
    }


    private int getSegmentSize(int n) {
        // 2^0 + 2^1 + 2^2 + 2^3 ... 2^h < 2* 2^h
        int h = log2Ceil(n);
        int e = (int) (Math.pow(2, h) * 2 - 1);
        return e;
    }

    private int leftOf(int position) {
        return 2 * position + 1;
    }

    private int rightOf(int position) {
        return 2 * position + 2;
    }

    private int log2Ceil(int n) {

        return (int) Math.ceil(Math.log(n) / Math.log(2));
    }

    public int[] getTree() {
        return tree;
    }

    public int[] getInput() {
        return input;
    }
}

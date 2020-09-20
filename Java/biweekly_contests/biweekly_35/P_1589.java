package biweekly_contests.biweekly_35;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1589 {

    private static final int MOD = (int) (1e9 + 7);

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long sum;
        long operation;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                sum = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            sum = left.sum + right.sum;
        }

        private void propagate() {
            if (leftMost == rightMost) {
                return;
            }
            left.operation += operation;
            right.operation += operation;
            left.sum += (left.rightMost - left.leftMost + 1) * operation;
            right.sum += (right.rightMost - right.leftMost + 1) * operation;
            operation = 0;
        }

        private long query(int l, int r) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void add(int l, int r, long v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                sum += (rightMost - leftMost + 1) * v;
                operation += v;
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            sum = left.sum + right.sum;
        }
    }

    public int maxSumRangeQueryST(int[] nums, int[][] requests) {
        final int n = nums.length;
        final SegTree st = new SegTree(0, n - 1, new int[n]);
        for (int[] req : requests) {
            st.add(req[0], req[1], 1);
        }
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer((int) st.query(i, i));
        }
        long res = 0;
        Arrays.sort(nums);
        int idx = n - 1;
        while (!pq.isEmpty()) {
            res = (res + pq.remove() * nums[idx--]) % MOD;
        }
        return (int) res;
    }

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        final int n = nums.length;
        final int[] freq = new int[n + 1];
        for (int[] req : requests) {
            freq[req[0]]++;
            freq[req[1] + 1]--;
        }
        for (int i = 1; i <= n; i++) {
            freq[i] += freq[i - 1];
        }
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(freq[i]);
        }
        Arrays.sort(nums);
        int idx = n - 1;
        long sum = 0;
        while (!pq.isEmpty()) {
            sum = (sum + (pq.remove() * nums[idx--])) % MOD;
        }
        return (int) sum;
    }
}

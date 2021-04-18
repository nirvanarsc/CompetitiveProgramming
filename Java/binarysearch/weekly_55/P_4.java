package binarysearch.weekly_55;

import java.util.Arrays;

public class P_4 {

    private static class BIT {
        public int[] arr;

        public BIT(int N) {
            arr = new int[N + 1];
        }

        // add k to the i-th element.
        public void add(int k, int i) {
            int node = i + 1;
            while (node < arr.length) {
                arr[node] += k;
                node += node & -node;
            }
        }

        // sum up the elements from input[s_i] to input[e_i], from [s_i,e_i].
        public int sum(int s_i, int e_i) {
            return sum(e_i + 1) - sum(s_i);
        }

        private int sum(int i) {
            int total = 0;
            int node = i;
            while (node > 0) {
                total += arr[node];
                node -= node & -node;
            }
            return total;
        }
    }

    public int[] solve(int[] tickets) {
        final int n = tickets.length;
        final BIT bit = new BIT(n);
        final BIT bitCNT = new BIT(n);
        final int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i] = new int[] { tickets[i], i };
        }
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                                                 : Integer.compare(a[0], b[0]));
        final int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            final int t = nums[i][0];
            final int idx = nums[i][1];

            final int cntL = bitCNT.sum(0, idx);
            final int sumL = bit.sum(0, idx);

            final int cntR = bitCNT.sum(idx, n - 1);
            final int sumR = bit.sum(idx, n - 1);

            final int base = (t - 1) * n + idx + 1;
            final int reduceL = cntL * t - sumL;
            final int reduceR = cntR * t - sumR - cntR;

            ans[idx] = base - reduceL - reduceR;

            bit.add(t, idx);
            bitCNT.add(1, idx);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P_4().solve(new int[] { 4, 1, 3, 1, 2 })));
    }
}

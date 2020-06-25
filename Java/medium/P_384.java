package medium;

import java.util.Random;

@SuppressWarnings("unused")
public class P_384 {

    static class Solution {

        int[] original;
        Random r;

        Solution(int[] nums) {
            original = nums;
            r = new Random();
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            final int[] res = original.clone();
            final int n = res.length;
            for (int i = 0; i < n; i++) {
                final int swapIdx = i + r.nextInt(n - i);
                swap(res, i, swapIdx);
            }
            return res;
        }

        private static void swap(int[] res, int i, int swapIdx) {
            final int t = res[i];
            res[i] = res[swapIdx];
            res[swapIdx] = t;
        }
    }
}



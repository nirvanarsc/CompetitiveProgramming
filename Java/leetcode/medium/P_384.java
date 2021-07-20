package leetcode.medium;

import java.util.Random;

@SuppressWarnings({ "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass", "unused" })
public class P_384 {

    class Solution {
        int[] original;
        int n;
        Random r;

        public Solution(int[] nums) {
            original = nums;
            n = nums.length;
            r = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return original;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            final int[] clone = original.clone();
            for (int i = 0; i < n; i++) {
                swap(clone, i, i + r.nextInt(n - i));
            }
            return clone;
        }

        private void swap(int[] arr, int i, int j) {
            final int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}



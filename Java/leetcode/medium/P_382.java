package leetcode.medium;

import java.util.Random;

import utils.DataStructures.ListNode;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass" })
public class P_382 {

    class Solution {

        ListNode head;
        Random r;

        public Solution(ListNode head) {
            this.head = head;
            r = new Random();
        }

        public int getRandom() {
            ListNode iter = head;
            int res = iter.val;
            int size = 1;
            while (iter != null) {
                final int swap = r.nextInt(size);
                if (swap == 0) {
                    res = iter.val;
                }
                iter = iter.next;
                size++;
            }
            return res;
        }
    }

    class SolutionBS {

        int n;
        int shift = (int) (1e4 + 5);
        int[] f = new int[2 * shift];
        int[] pre;
        int[] map;
        Random r;

        public SolutionBS(ListNode head) {
            for (ListNode node = head; node != null; node = node.next) {
                f[node.val + shift]++;
            }
            for (int count : f) {
                if (count > 0) {
                    n++;
                }
            }
            pre = new int[n];
            map = new int[n];
            r = new Random();
            n = 0;
            for (int i = 0; i < f.length; i++) {
                if (f[i] > 0) {
                    map[n] = i - shift;
                    pre[n] = (n > 0 ? pre[n - 1] : 0) + f[i];
                    n++;
                }
            }
        }

        public int getRandom() {
            return map[lowerBound(pre, 1 + r.nextInt(pre[n - 1]))];
        }

        private int lowerBound(int[] arr, int target) {
            int lo = 0, hi = arr.length;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (arr[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}


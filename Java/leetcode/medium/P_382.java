package leetcode.medium;

import java.util.Random;

import utils.DataStructures.ListNode;

@SuppressWarnings("unused")
public class P_382 {

    static class Solution {

        ListNode head;
        Random r;

        Solution(ListNode head) {
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
}


package leetcode.weekly_contests.weekly_54;

import java.util.HashMap;
import java.util.Map;

public class P_697 {

    static class Item {
        int first;
        int last;
        int freq;

        Item(int first, int last, int freq) {
            this.first = first;
            this.last = last;
            this.freq = freq;
        }
    }

    public int findShortestSubArray(int[] nums) {
        final Map<Integer, Item> freq = new HashMap<>();
        int degree = 1, res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!freq.containsKey(nums[i])) {
                freq.put(nums[i], new Item(i, i, 1));
            } else {
                final Item item = freq.get(nums[i]);
                item.freq++;
                item.last = i;
                degree = Math.max(degree, item.freq);
            }
        }
        for (Item i : freq.values()) {
            if (i.freq == degree) {
                res = Math.min(res, i.last - i.first + 1);
            }
        }
        return res;
    }
}

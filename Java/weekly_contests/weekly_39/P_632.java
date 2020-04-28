package weekly_contests.weekly_39;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P_632 {

    static class Item {
        int rowIdx;
        int colIdx;
        int value;

        Item(int rowIdx, int colIdx, int value) {
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
            this.value = value;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int currLo = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;
        final PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new Item(i, 0, nums.get(i).get(0)));
            currLo = Math.min(currLo, nums.get(i).get(0));
            currMax = Math.max(currMax, nums.get(i).get(0));
        }
        final int[] res = { currLo, currMax };
        while (true) {
            final Item curr = pq.remove();
            if (curr.colIdx + 1 == nums.get(curr.rowIdx).size()) {
                return res;
            }
            final Integer next = nums.get(curr.rowIdx).get(curr.colIdx + 1);
            pq.offer(new Item(curr.rowIdx, curr.colIdx + 1, next));
            currLo = pq.element().value;
            currMax = Math.max(currMax, next);
            if (currMax - currLo < res[1] - res[0]) {
                res[0] = currLo;
                res[1] = currMax;
            }
        }
    }
}


package leetcode.weekly_contests.weekly_0_99.weekly_37;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_624 {

    static class Item {
        int idx;
        int val;

        Item(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public int maxDistance(List<List<Integer>> arrays) {
        final List<Item> min = new ArrayList<>();
        final List<Item> max = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            min.add(new Item(i, arrays.get(i).get(0)));
            max.add(new Item(i, arrays.get(i).get(arrays.get(i).size() - 1)));
        }
        min.sort(Comparator.comparingInt(a -> a.val));
        max.sort((a, b) -> Integer.compare(b.val, a.val));
        if (min.get(0).idx == max.get(0).idx) {
            return Math.max(max.get(1).val - min.get(0).val, max.get(0).val - min.get(1).val);
        }
        return max.get(0).val - min.get(0).val;
    }
}

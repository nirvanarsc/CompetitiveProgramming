package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FirstUnique {

    int i;
    Map<Integer, Integer> seen = new HashMap<>();
    List<Integer> q = new ArrayList<>();

    FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (i < q.size() && seen.get(q.get(i)) > 1) {
            i++;
        }
        return i == q.size() ? -1 : q.get(i);
    }

    public void add(int value) {
        q.add(value);
        seen.merge(value, 1, Integer::sum);
    }
}

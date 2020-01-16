package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_692 {

    public List<String> topKFrequent(String[] words, int k) {
        final Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.merge(s, 1, Integer::sum);
        }
        final Comparator<String> stringComparator = (a, b) ->
                map.get(a).equals(map.get(b)) ? a.compareTo(b) : Integer.compare(map.get(b), map.get(a));
        final PriorityQueue<String> pq = new PriorityQueue<>(stringComparator);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry.getKey());
        }
        final List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }
}

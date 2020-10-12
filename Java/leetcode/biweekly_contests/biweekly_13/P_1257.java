package leetcode.biweekly_contests.biweekly_13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_1257 {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        final Map<String, String> graph = new HashMap<>();
        for (List<String> region : regions) {
            for (int i = 1; i < region.size(); i++) {
                graph.put(region.get(i), region.get(0));
            }
        }
        final Set<String> seen = new HashSet<>();
        while (region1 != null) {
            seen.add(region1);
            region1 = graph.get(region1);
        }
        while (!seen.contains(region2)) {
            region2 = graph.get(region2);
        }
        return region2;
    }
}

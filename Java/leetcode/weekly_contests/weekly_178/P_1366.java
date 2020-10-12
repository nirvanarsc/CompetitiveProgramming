package leetcode.weekly_contests.weekly_178;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P_1366 {

    public String rankTeams(String[] votes) {
        final List<Character> res = new ArrayList<>();
        for (char c : votes[0].toCharArray()) {
            res.add(c);
        }
        final Map<Integer, Map<Character, Integer>> map = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                map.computeIfAbsent(i, v -> new HashMap<>()).merge(vote.charAt(i), 1, Integer::sum);
            }
        }
        res.sort((a, b) -> {
            for (int i = 0; i < votes[0].length(); i++) {
                if (!map.get(i).getOrDefault(a, 0).equals(map.get(i).getOrDefault(b, 0))) {
                    return Integer.compare(map.get(i).getOrDefault(b, 0),
                                           map.get(i).getOrDefault(a, 0));
                }
            }
            return Character.compare(a, b);
        });
        return res.stream().map(String::valueOf).collect(Collectors.joining());
    }
}

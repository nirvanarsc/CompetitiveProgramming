package weekly_contests.weekly_103;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P_911 {

    static class TopVotedCandidate {
        TreeMap<Integer, Integer> results = new TreeMap<>();
        int lead = -1;

        TopVotedCandidate(int[] persons, int[] times) {
            final Map<Integer, Integer> count = new HashMap<>();
            for (int i = 0; i < times.length; i++) {
                count.merge(persons[i], 1, Integer::sum);
                if (i == 0 || count.get(persons[i]) >= count.get(lead)) {
                    lead = persons[i];
                }
                results.put(times[i], lead);
            }
        }

        public int q(int t) {
            return results.floorEntry(t).getValue();
        }
    }
}



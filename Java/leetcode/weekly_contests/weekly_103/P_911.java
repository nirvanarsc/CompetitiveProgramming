package leetcode.weekly_contests.weekly_103;

import java.util.Collections;
import java.util.TreeMap;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_911 {

    class TopVotedCandidate {
        TreeMap<Integer, Integer> tm;

        TopVotedCandidate(int[] persons, int[] times) {
            final int[] votes = new int[5001];
            int currMax = 0;
            int currWinner = 0;
            tm = new TreeMap<>(Collections.singletonMap(currMax, currWinner));
            for (int i = 0; i < times.length; i++) {
                if (currMax < ++votes[persons[i]]) {
                    currMax = votes[persons[i]];
                    currWinner = persons[i];
                } else if (currMax == votes[persons[i]]) {
                    currWinner = persons[i];
                }
                tm.put(times[i], currWinner);
            }
        }

        public int q(int t) {
            return tm.floorEntry(t).getValue();
        }
    }
}



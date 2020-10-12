package leetcode.biweekly_contests.biweekly_12;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P_1244 {

    static class Leaderboard {
        Map<Integer, Integer> players;
        TreeMap<Integer, Integer> scores;

        Leaderboard() {
            players = new HashMap<>();
            scores = new TreeMap<>(Comparator.reverseOrder());
        }

        public void addScore(int playerId, int score) {
            if (players.containsKey(playerId)) {
                final Integer oldScore = players.get(playerId);
                scores.merge(oldScore, -1, Integer::sum);
                if (scores.get(oldScore) == 0) {
                    scores.remove(oldScore);
                }
                players.put(playerId, oldScore + score);
                scores.merge(oldScore + score, 1, Integer::sum);
            } else {
                players.put(playerId, score);
                scores.merge(score, 1, Integer::sum);
            }
        }

        public int top(int k) {
            int res = 0;
            Map.Entry<Integer, Integer> first = scores.firstEntry();
            while (k > 0) {
                for (int i = 0; i < first.getValue() && k > 0; i++) {
                    res += first.getKey();
                    k--;
                }
                first = scores.higherEntry(first.getKey());
            }
            return res;
        }

        public void reset(int playerId) {
            final Integer score = players.get(playerId);
            players.remove(playerId);
            scores.merge(score, -1, Integer::sum);
            if (scores.get(score) == 0) {
                scores.remove(score);
            }
        }
    }
}

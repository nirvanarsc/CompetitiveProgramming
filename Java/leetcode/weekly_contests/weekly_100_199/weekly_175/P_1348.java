package leetcode.weekly_contests.weekly_100_199.weekly_175;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P_1348 {

    static class TweetCounts {
        private final Map<String, TreeMap<Integer, Integer>> map;

        TweetCounts() {
            map = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time) {
            map.putIfAbsent(tweetName, new TreeMap<>());
            map.get(tweetName).merge(time, 1, Integer::sum);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq,
                                                        String tweetName,
                                                        int startTime,
                                                        int endTime) {
            if (!map.containsKey(tweetName)) {
                return null;
            }
            final List<Integer> res = new LinkedList<>();
            final int interval;
            final int size;
            if ("minute".equals(freq)) {
                interval = 60;
            } else if ("hour".equals(freq)) {
                interval = 3600;
            } else {
                interval = 86400;
            }
            size = ((endTime - startTime) / interval) + 1;
            final int[] buckets = new int[size];
            final TreeMap<Integer, Integer> tweetMap = map.get(tweetName);
            for (Map.Entry<Integer, Integer> entry : tweetMap.subMap(startTime, endTime + 1).entrySet()) {
                final int index = (entry.getKey() - startTime) / interval;
                buckets[index] += entry.getValue();
            }
            for (int num : buckets) {
                res.add(num);
            }
            return res;
        }
    }
}

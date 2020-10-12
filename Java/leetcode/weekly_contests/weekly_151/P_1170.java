package leetcode.weekly_contests.weekly_151;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        final Map<Integer, Integer> count = new HashMap<>();
        for (String w : words) {
            count.merge(f(w), 1, Integer::sum);
        }
        final List<Integer> integers = new ArrayList<>(count.keySet());
        Collections.sort(integers);
        final int[] prefixSum = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            prefixSum[i] = (i > 0 ? prefixSum[i - 1] : 0) + count.get(integers.get(i));
        }
        final int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            final int f = f(queries[i]);
            int lo = 0;
            int hi = integers.size();
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (integers.get(mid) <= f) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            res[i] = prefixSum[integers.size() - 1] - (lo > 0 ? prefixSum[lo - 1] : 0);
        }
        return res;
    }

    private static int f(String w) {
        final int[] map = new int[26];
        for (char c : w.toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return map[i];
            }
        }
        return -1;
    }

    public int[] numSmallerByFrequencyBS(String[] queries, String[] words) {
        final int[] res = new int[queries.length];
        final int[] wordMap = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordMap[i] = f(words[i]);
        }
        Arrays.sort(wordMap);
        for (int i = 0; i < queries.length; i++) {
            final int frequency = f(queries[i]);
            if (wordMap[words.length - 1] <= frequency) {
                res[i] = 0;
            } else {
                res[i] = words.length - binarySearch(wordMap, frequency);
            }
        }
        return res;
    }

    private static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int[] numSmallerByFrequencyCountingSort(String[] queries, String[] words) {
        final int[] wordScores = new int[words.length];
        final int[] scoreMap = new int[11];
        final int[] prefixSumScore = new int[11];
        final int[] res = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            wordScores[i] = f(words[i]);
            scoreMap[wordScores[i]]++;
        }
        prefixSumScore[0] = scoreMap[0];
        for (int i = 1; i < scoreMap.length; i++) {
            prefixSumScore[i] = prefixSumScore[i - 1] + scoreMap[i];
        }
        for (int i = 0; i < queries.length; i++) {
            final String query = queries[i];
            final int score = f(query);
            res[i] = words.length - prefixSumScore[score];
        }
        return res;
    }
}

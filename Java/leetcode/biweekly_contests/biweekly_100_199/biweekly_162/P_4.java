package leetcode.biweekly_contests.biweekly_100_199.biweekly_162;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class P_4 {

    private int maxFreq;
    private Map<Integer, Integer> freq;
    private TreeMap<Integer, TreeSet<Integer>> freqGroups;

    // https://cp-algorithms.com/data_structures/sqrt_decomposition.html
    public int[] subarrayMajority(int[] nums, int[][] queries) {
        final int n = nums.length;
        final int q = queries.length;
        final int blockSize = (int) Math.sqrt(n);
        final int[][] sortedQueries = new int[q][4];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i][0];
            sortedQueries[i][1] = queries[i][1];
            sortedQueries[i][2] = queries[i][2];
            sortedQueries[i][3] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> {
            final int blockA = a[0] / blockSize;
            final int blockB = b[0] / blockSize;
            return blockA == blockB ? Integer.compare(a[1], b[1]) : Integer.compare(blockA, blockB);
        });
        freq = new HashMap<>();
        freqGroups = new TreeMap<>();
        maxFreq = 0;
        final int[] res = new int[q];
        int L = 0, R = -1;
        for (int[] query : sortedQueries) {
            final int left = query[0];
            final int right = query[1];
            final int threshold = query[2];
            final int idx = query[3];
            while (R < right) { add(nums[++R]); }
            while (R > right) { remove(nums[R--]); }
            while (L < left) { remove(nums[L++]); }
            while (L > left) { add(nums[--L]); }
            res[idx] = maxFreq >= threshold ? freqGroups.get(maxFreq).first() : -1;
        }
        return res;
    }

    private void add(int val) {
        final int oldFreq = freq.getOrDefault(val, 0);
        if (oldFreq > 0) {
            final TreeSet<Integer> oldSet = freqGroups.get(oldFreq);
            oldSet.remove(val);
            if (oldSet.isEmpty()) { freqGroups.remove(oldFreq); }
        }
        final int newFreq = oldFreq + 1;
        freq.put(val, newFreq);
        freqGroups.computeIfAbsent(newFreq, k -> new TreeSet<>()).add(val);
        if (newFreq > maxFreq) { maxFreq = newFreq; }
    }

    private void remove(int val) {
        final int oldFreq = freq.get(val);
        final TreeSet<Integer> oldSet = freqGroups.get(oldFreq);
        oldSet.remove(val);
        if (oldSet.isEmpty()) { freqGroups.remove(oldFreq); }
        final int newFreq = oldFreq - 1;
        if (newFreq > 0) {
            freq.put(val, newFreq);
            freqGroups.computeIfAbsent(newFreq, k -> new TreeSet<>()).add(val);
        } else {
            freq.remove(val);
        }
        if (freqGroups.isEmpty()) {
            maxFreq = 0;
        } else {
            maxFreq = freqGroups.lastKey();
        }
    }
}

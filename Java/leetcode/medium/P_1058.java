package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_1058 {

    public String minimizeError(String[] prices, int target) {
        final double[] p = new double[prices.length];
        for (int i = 0; i < prices.length; i++) {
            p[i] = Double.parseDouble(prices[i]);
        }
        final double dfs = dfs(p, target, 0, 0, new HashMap<>());
        if (Double.compare(dfs, -1) == 0) {
            return "-1";
        }
        return String.format("%.3f", dfs);
    }

    private static double dfs(double[] p, int target, int curr, int idx, Map<String, Double> dp) {
        if (idx == p.length || curr > target) {
            return curr == target ? 0 : -1;
        }
        final String key = idx + "," + curr;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        final double ceil = Math.ceil(p[idx]);
        final double floor = Math.floor(p[idx]);
        double res = 1e9;
        final double roundUp = dfs(p, target, curr + (int) ceil, idx + 1, dp);
        if (Double.compare(roundUp, -1) != 0) {
            res = Math.min(res, ceil - p[idx] + roundUp);
        }
        final double roundDown = dfs(p, target, curr + (int) floor, idx + 1, dp);
        if (Double.compare(roundDown, -1) != 0) {
            res = Math.min(res, p[idx] - floor + roundDown);
        }
        if (Double.compare(res, 1e9) == 0) {
            res = -1;
        }
        dp.put(key, res);
        return res;
    }

    public String minimizeErrorPQ(String[] prices, int target) {
        final PriorityQueue<Double> diffHeap = new PriorityQueue<>();
        double res = 0;
        for (String s : prices) {
            final double f = Double.parseDouble(s);
            final double low = Math.floor(f);
            final double high = Math.ceil(f);
            if (Double.compare(low, high) != 0) {
                diffHeap.offer(high - f - (f - low));
            }
            res += f - low;
            target -= low;
        }
        if (target < 0 || target > diffHeap.size()) {
            return "-1";
        }
        while (target-- > 0) {
            res += diffHeap.remove();
        }
        return String.format("%.3f", res);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kmp("abcddbcfda")));


    }

    private static int[] kmp(String s) {
        final int n = s.length();
        final int[] prefixSuffix = new int[n];
        int max = 0;
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefixSuffix[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            prefixSuffix[i] = j;
            max = Math.max(max, prefixSuffix[i]);
        }
        System.out.println(max);
        return prefixSuffix;
    }
}

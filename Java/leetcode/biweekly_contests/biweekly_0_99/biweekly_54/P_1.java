package leetcode.biweekly_contests.biweekly_0_99.biweekly_54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1 {

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            for (int j = 0; j < words[i].length(); j++) {
                String curr = rev.substring(j);
                System.out.println(curr);
                if (isPalindrome(words[i] + curr)) {
                    Integer idx = map.get(curr);
                    if (idx != null) {
                        res.add(Arrays.asList(i, idx));
                    }
                }
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        final boolean[] total = new boolean[100];
        for (int[] r : ranges) {
            for (int i = r[0]; i <= r[1]; i++) {
                total[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!total[i]) {
                return false;
            }
        }
        return true;
    }
}

package leetcode.weekly_contests.weekly_26;

import java.util.Arrays;
import java.util.Comparator;

public class P_522 {

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        for (int i = strs.length - 1; i >= 0; i--) {
            int count = 0;
            for (String str : strs) {
                if (!isSubSequence(strs[i], str)) {
                    count++;
                }
            }
            if (count == strs.length - 1) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private static boolean isSubSequence(String s1, String s2) {
        int idx = 0;
        for (char ch : s2.toCharArray()) {
            if (idx < s1.length() && ch == s1.charAt(idx)) {
                idx++;
            }
        }
        return idx == s1.length();
    }
}

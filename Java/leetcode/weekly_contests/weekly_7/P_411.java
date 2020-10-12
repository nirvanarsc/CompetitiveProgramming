package leetcode.weekly_contests.weekly_7;

import java.util.HashSet;
import java.util.Set;

public class P_411 {

    int minLen;
    int result;

    public String minAbbreviation(String target, String[] dictionary) {
        minLen = target.length() + 1;
        result = -1;
        int zeroCount = 0;
        final StringBuilder res = new StringBuilder();
        final Set<Integer> maskSet = new HashSet<>();

        for (String word : dictionary) {
            if (word.length() == target.length()) {
                maskSet.add(toMask(word, target));
            }
        }

        dfs(target, maskSet, 0, 0, 0);

        if (minLen > target.length()) {
            return "";
        }

        for (int i = target.length() - 1; i >= 0; i--) {
            final int digit = result & 1;
            if (digit == 0) {
                zeroCount++;
            } else {
                if (zeroCount > 0) {
                    res.insert(0, zeroCount);
                    zeroCount = 0;
                }
                res.insert(0, target.charAt(i));
            }
            result >>= 1;
        }
        if (zeroCount > 0) {
            res.insert(0, zeroCount);
        }
        return res.toString();
    }

    private void dfs(String target, Set<Integer> maskSet, int start, int currLen, int currRes) {
        if (currLen >= minLen) {
            return;
        }
        if (start == target.length()) {
            for (int mask : maskSet) {
                if ((currRes & mask) == currRes) {
                    return;
                }
            }
            minLen = currLen;
            result = currRes;
            return;
        }
        for (int i = start; i < target.length(); i++) {
            if (currLen == 0 || (currRes & 1) == 1) {
                dfs(target, maskSet, i + 1, currLen + 1, currRes << (i + 1 - start));
            }
        }
        dfs(target, maskSet, start + 1, currLen + 1, (currRes << 1) + 1);
    }

    private static int toMask(String word, String target) {
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            mask <<= 1;
            if (word.charAt(i) == target.charAt(i)) {
                mask += 1;
            }
        }
        return mask;
    }
}

package leetcode.weekly_contests.weekly_104;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_916 {

    public List<String> wordSubsets(String[] A, String[] B) {
        final int[] bMap = new int[26];
        for (String b : B) {
            final int[] currMap = new int[26];
            for (char c : b.toCharArray()) {
                currMap[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                bMap[i] = Math.max(bMap[i], currMap[i]);
            }
        }
        final List<String> res = new ArrayList<>();
        for (String a : A) {
            final int[] currMap = new int[26];
            for (char c : a.toCharArray()) {
                currMap[c - 'a']++;
            }
            boolean allMatch = true;
            for (int i = 0; i < 26; i++) {
                if (bMap[i] > 0 && bMap[i] > currMap[i]) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) {
                res.add(a);
            }
        }
        return res;
    }
}

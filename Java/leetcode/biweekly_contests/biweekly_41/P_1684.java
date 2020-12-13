package leetcode.biweekly_contests.biweekly_41;

public class P_1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        final int[] ok = new int[26];
        for (char c : allowed.toCharArray()) {
            ok[c - 'a']++;
        }
        int res = 0;
        for (String w : words) {
            boolean isOk = true;
            for (char c : w.toCharArray()) {
                if (ok[c - 'a'] == 0) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                res++;
            }
        }
        return res;
    }
}

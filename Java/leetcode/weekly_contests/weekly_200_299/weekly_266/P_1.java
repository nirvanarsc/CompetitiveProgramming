package leetcode.weekly_contests.weekly_200_299.weekly_266;

public class P_1 {

    static int good;

    public int countVowelSubstrings(String word) {
        good = 0;
        for (char c : "aeiou".toCharArray()) {
            good |= 1 << (c - 'a');
        }
        final int n = word.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int mask = 0;
                for (int k = i; k <= j; k++) {
                    mask |= 1 << word.charAt(k) - 'a';
                }
                if ((mask ^ good) == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}

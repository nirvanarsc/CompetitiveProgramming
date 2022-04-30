package leetcode.biweekly_contests.biweekly_77;

public class P_1 {

    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String w : words) {
            if (s.startsWith(w)) {
                res++;
            }
        }
        return res;
    }
}

package leetcode.weekly_contests.weekly_300_399.weekly_331;

public class P_2 {

    public int[] vowelStrings(String[] words, int[][] queries) {
        final int n = words.length;
        final int[] pre = new int[n + 1];
        final String vowels = "aeiou";
        for (int i = 0; i < n; i++) {
            if (vowels.indexOf(words[i].charAt(0)) != -1 &&
                vowels.indexOf(words[i].charAt(words[i].length() - 1)) != -1) {
                pre[i + 1] += 1;
            }
            pre[i + 1] += pre[i];
        }
        final int q = queries.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int l = queries[i][0];
            final int r = queries[i][1];
            res[i] = pre[r + 1] - pre[l];
        }
        return res;
    }
}

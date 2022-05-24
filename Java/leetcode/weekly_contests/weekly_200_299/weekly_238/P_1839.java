package leetcode.weekly_contests.weekly_200_299.weekly_238;

public class P_1839 {

    public int longestBeautifulSubstring(String word) {
        final String vowels = "aeiou";
        int res = 0;
        final int n = word.length();
        final char[] w = word.toCharArray();
        for (int i = 0; i < n; i++) {
            if (w[i] == 'a') {
                int j = i;
                int k = 0;
                boolean ok = true;
                while (k < 5) {
                    while (j < n && w[j] == vowels.charAt(k)) {
                        j++;
                    }
                    if (k == 4 || j < n && w[j] == vowels.charAt(k + 1)) {
                        k++;
                    } else {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    res = Math.max(res, j - i);
                }
                i = j - 1;
            }
        }
        return res;
    }
}

package weekly_contests.weekly_68;

public class P_767 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String reorganizeString(String S) {
        final int[] freq = new int[26];
        for (int i = 0; i < S.length(); i++) {
            freq[S.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        final char[] res = new char[S.length()];
        int idx = 0;
        while (freq[letter]-- > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
        }
        for (int i = 0; i < freq.length; i++) {
            while (freq[i]-- > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
            }
        }
        return String.valueOf(res);
    }
}

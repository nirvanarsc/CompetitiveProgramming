package biweekly_7;

public class P_1165 {

    public int calculateTime(String keyboard, String word) {
        final int[] map = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            map[keyboard.charAt(i) - 'a'] = i;
        }
        int res = 0;
        int prev = 0;
        for (int i = 0; i < word.length(); i++) {
            final int idx = map[word.charAt(i) - 'a'];
            res += Math.abs(idx - prev);
            prev = idx;
        }
        return res;
    }
}

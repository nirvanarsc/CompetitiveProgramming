package easy;

public class P_1165 {

    public int calculateTime(String keyboard, String word) {
        final int[] map = new int[keyboard.length()];
        for (int i = 0; i < keyboard.length(); i++) {
            map[keyboard.charAt(i) - 'a'] = i;
        }
        int prev = 0;
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            final int nextIdx = word.charAt(i) - 'a';
            res += Math.abs(map[nextIdx] - prev);
            prev = map[nextIdx];
        }
        return res;
    }
}

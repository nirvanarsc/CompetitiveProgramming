package weekly_contests.weekly_2;

public class P_389 {

    public char findTheDifference(String s, String t) {
        final int n = t.length() - 1;
        char c = t.charAt(n);
        for (int i = 0; i < n; ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

    public char findTheDifferenceCount(String s, String t) {
        final int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (map[c - 'a']-- == 0) {
                return c;
            }
        }
        return '*';
    }
}

package leetcode.hard;

public final class P_76 {

    public String minWindow(String s, String t) {
        final int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int min = Integer.MAX_VALUE;
        int minStart = -1;
        int matches = t.length();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]-- > 0) {
                matches--;
            }
            while (matches == 0) {
                if (min > i - j + 1) {
                    min = i - j + 1;
                    minStart = j;
                }
                if (++count[s.charAt(j++)] > 0) {
                    matches++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + min);
    }
}

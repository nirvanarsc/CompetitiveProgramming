package hard;

public final class P_76 {

    public static String minWindow(String s, String t) {
        final int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (count[c1] > 0) {
                counter--;
            }
            count[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start++);
                if (++count[c2] > 0) {
                    counter++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    private P_76() {}
}

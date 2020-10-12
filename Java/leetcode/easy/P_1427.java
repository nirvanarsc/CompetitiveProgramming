package leetcode.easy;

public class P_1427 {

    public String stringShift(String s, int[][] shift) {
        int k = 0;
        for (int[] dir : shift) {
            k += dir[0] == 1 ? dir[1] : -dir[1];
        }
        k = Math.floorMod(k, s.length());
        final char[] chars = s.toCharArray();
        rotate(chars, k);
        return new String(chars);
    }

    public static void rotate(char[] chars, int k) {
        k %= chars.length;
        reverse(0, chars.length - 1, chars);
        reverse(0, k - 1, chars);
        reverse(k, chars.length - 1, chars);
    }

    private static void reverse(int from, int to, char[] chars) {
        for (int i = from; 2 * i < to + from; i++) {
            final char temp = chars[i];
            chars[i] = chars[to + from - i];
            chars[to + from - i] = temp;
        }
    }
}

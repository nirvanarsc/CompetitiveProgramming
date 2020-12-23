package leetcode.weekly_contests.weekly_27;

@SuppressWarnings("ReturnOfNull")
public class P_556 {

    public int nextGreaterElement(int n) {
        final char[] str = String.valueOf(n).toCharArray();
        final char[] res = nextP(str);
        if (res == null) {
            return -1;
        }
        final long val = Long.parseLong(new String(res));
        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }

    private static void reverse(char[] str, int start, int end) {
        while (start < end) {
            final char t = str[start];
            str[start] = str[end];
            str[end] = t;
            start++;
            end--;
        }
    }

    private static char[] nextP(char[] str) {
        int j = str.length - 2;
        while (j >= 0 && str[j] >= str[j + 1]) {
            j--;
        }
        if (j == -1) {
            return null;
        }
        int swap = str.length - 1;
        while (swap > j && str[j] >= str[swap]) {
            swap--;
        }
        final char t = str[j];
        str[j] = str[swap];
        str[swap] = t;
        reverse(str, j + 1, str.length - 1);
        return str;
    }
}

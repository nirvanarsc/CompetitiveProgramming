package medium;

public class P_1209 {

    public String removeDuplicatesImproved(String s, int k) {
        int i = 0;
        final int[] count = new int[s.length()];
        final char[] array = s.toCharArray();

        for (int j = 0; j < s.length(); i++, j++) {
            array[i] = array[j];
            count[i] = (i > 0 && array[i] == array[i - 1]) ? count[i - 1] + 1 : 1;
            if (count[i] == k) {
                i -= k;
            }
        }

        return new String(array, 0, i);
    }

    public String removeDuplicates(String s, int k) {
        int i = 0;
        final char[] stack = new char[s.length()];
        for (int j = 0; j < s.length(); ++j) {
            if (i > k - 2 && allMatch(s, k, i, j, stack)) {
                i -= k - 1;
            } else {
                stack[i++] = s.charAt(j);
            }
        }
        return new String(stack, 0, i);
    }

    private static boolean allMatch(String s, int k, int i, int j, char[] stack) {
        for (int t = i - k + 1; t < i; t++) {
            if (stack[t] != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

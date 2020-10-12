package leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

public final class P_151 {

    private static final Pattern COMPILE = Pattern.compile("\\s+");

    public static String reverseWords(String s) {
        s = COMPILE.matcher(s.trim()).replaceAll(" ");

        final char[] chars = s.toCharArray();
        reverseWords(chars);
        return new String(chars);
    }

    public static void reverseWords(char[] input) {
        final int end = input.length - 1;
        int prev = 0;

        reverse(input, 0, end);

        for (int i = 0; i <= end; i++) {
            if (i == end && input[i] != ' ') {
                reverse(input, prev, end);
            } else if (input[i] == ' ') {
                reverse(input, prev, i - 1);
                prev = i + 1;
            }
        }
    }

    private static void reverse(char[] input, int from, int to) {
        while (from < to) {
            final char temp = input[from];
            input[from] = input[to];
            input[to] = temp;
            from++;
            to--;
        }
    }

    public static String reverseWords2(String s) {
        final String[] arr = COMPILE.split(s.trim());
        Collections.reverse(Arrays.asList(arr));
        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
    }

    private P_151() {}
}

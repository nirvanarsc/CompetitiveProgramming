import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("3z4"));
        System.out.println(letterCasePermutation("12345"));

        System.out.println(letterCasePermutation2("a1b2"));
        System.out.println(letterCasePermutation2("3z4"));
        System.out.println(letterCasePermutation2("12345"));
    }

    public static List<String> letterCasePermutation(String s) {
        final List<String> res = new ArrayList<>(Collections.singletonList(s));

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (isUpperCase(c) || isLowerCase(c)) {
                final List<String> permutations = new ArrayList<>();
                for (int j = 0; j < res.size(); j++) {
                    final char[] p = res.get(j).toCharArray();
                    if (isUpperCase(c)) { p[i] += ' '; } else { p[i] -= ' '; }
                    permutations.add(String.copyValueOf(p));
                }
                res.addAll(permutations);
            }
        }

        return res;
    }

    public static List<String> letterCasePermutation2(String s) {
        final LinkedList<String> res = new LinkedList<>(Collections.singletonList(s));

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (Character.isLetter(c)) {
                for (int size = res.size(); size > 0; size--) {
                    final String str = res.poll();
                    final String left = str.substring(0, i);
                    final String right = str.substring(i + 1);
                    res.add(left + Character.toLowerCase(c) + right);
                    res.add(left + Character.toUpperCase(c) + right);
                }
            }
        }
        return res;
    }

    private static boolean isUpperCase(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private static boolean isLowerCase(char c) {
        return 'a' <= c && c <= 'z';
    }

    private LetterCasePermutation() {}
}

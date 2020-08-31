package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_500 {

    public static final String[] STRINGS = {};

    public String[] findWords(String[] words) {
        final Set<Character> row1 = new HashSet<>(
                Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        final Set<Character> row2 = new HashSet<>(
                Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        final Set<Character> row3 = new HashSet<>(
                Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        final List<String> res = new ArrayList<>();
        for (String word : words) {
            if (checkRow(row1, word) || checkRow(row2, word) || checkRow(row3, word)) {
                res.add(word);
            }
        }
        return res.toArray(STRINGS);
    }

    private static boolean checkRow(Set<Character> row, String word) {
        for (char c : word.toCharArray()) {
            if (!row.contains(Character.toLowerCase(c))) {
                return false;
            }
        }
        return true;
    }
}

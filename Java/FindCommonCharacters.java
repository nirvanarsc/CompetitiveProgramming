import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FindCommonCharacters {

    public static void main(String[] args) {
        final String[] s = {
                "acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"
        };
        final String[] s2 = {
                "cool", "lock", "cook"
        };

        commonChars(s).forEach(System.out::println);
        commonChars(s2).forEach(System.out::println);

    }

    public static List<String> commonChars(String[] a) {
        final List<String> res = new ArrayList<>();
        final int[] map = new int[26];
        Arrays.fill(map, Integer.MAX_VALUE);

        for (String s : a) {
            updateMap(map, s);
        }

        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                while (map[i]-- > 0) {
                    res.add(String.valueOf((char) (i + 'a')));
                }
            }
        }

        return res;
    }

    private static void updateMap(int[] map, String s) {
        final int[] sMap = new int[26];
        for (char c : s.toCharArray()) {
            sMap[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            map[i] = Math.min(sMap[i], map[i]);
        }
    }

    private FindCommonCharacters() {}
}

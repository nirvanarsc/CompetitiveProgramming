import java.util.ArrayList;
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

        for (char c : a[0].toCharArray()) {
            map[c - 'a']++;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (map[j] == 0) {
                    continue;
                }
                if (!a[i].contains(String.valueOf((char) (j + 'a')))) {
                    map[j] = 0;
                    continue;
                }
                updateMap(map, a[i], j);
            }
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

    private static void updateMap(int[] map, String s, int i) {
        int occurrences = 0;
        for (char c : s.toCharArray()) {
            if (c == (char) (i + 'a')) {
                occurrences++;
            }
        }
        map[i] = Math.min(map[i], occurrences);
    }

    private FindCommonCharacters() {}
}

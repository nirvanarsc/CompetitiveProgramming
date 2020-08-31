package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1002 {

    public List<String> commonChars(String[] A) {
        final List<String> res = new ArrayList<>();
        final int[] map = new int[26];
        Arrays.fill(map, Integer.MAX_VALUE);
        for (String word : A) {
            updateMap(map, word);
        }
        for (int i = 0; i < 26; i++) {
            while (map[i]-- > 0) {
                res.add(String.valueOf((char) (i + 'a')));
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
}

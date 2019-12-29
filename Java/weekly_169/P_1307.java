package weekly_169;

import java.util.Arrays;

public class P_1307 {

    public boolean isSolvable(String[] words, String result) {
        int i = 0;
        final int[] map = new int[26];
        Arrays.fill(map, -1);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (map[c - 'A'] == -1) {
                    map[c - 'A'] = i++;
                }
            }
        }
        for (char c : result.toCharArray()) {
            if (map[c - 'A'] == -1) {
                map[c - 'A'] = i++;
            }
        }
        return isSolvable(words, result, new int[i], 0, map, new boolean[10]);
    }

    private static boolean isSolvable(String[] words,
                                      String result,
                                      int[] value,
                                      int index,
                                      int[] map,
                                      boolean[] set) {
        if (index == value.length) {
            final int[] sum = new int[words.length];
            int c = 0, S = 0;
            for (int j = 0; j < sum.length; j++) {
                for (int i = 0; i < words[j].length(); i++) {
                    sum[j] = sum[j] * 10 + value[map[words[j].charAt(i) - 'A']];
                }
                S += sum[j];
            }
            for (int i = 0; i < result.length(); i++) {
                c = c * 10 + value[map[result.charAt(i) - 'A']];
            }
            return S == c;
        } else {
            for (int i = 0; i <= 9; i++) {
                if (!set[i]) {
                    set[i] = true;
                    value[index] = i;
                    if (isSolvable(words, result, value, index + 1, map, set)) {
                        return true;
                    }
                    set[i] = false;
                }
            }
            return false;
        }
    }
}

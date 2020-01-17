package easy;

public class P_1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        final int[] res = new int[queries.length];
        final int[] wordMap = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordMap[i] = getFrequency(words[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            int t = 0;
            final int curr = getFrequency(queries[i]);
            for (int j : wordMap) {
                if (curr < j) {
                    t++;
                }
            }
            res[i] = t;
        }
        return res;
    }

    private static int getFrequency(String word) {
        final int[] map = new int[27];
        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }
        for (int value : map) {
            if (value > 0) {
                return value;
            }
        }
        return -1;
    }
}

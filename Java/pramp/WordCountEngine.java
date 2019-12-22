package pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public final class WordCountEngine {

    private static final Pattern PUNCTUATION = Pattern.compile("[^a-zA-Z ]");
    private static final Pattern SPACES = Pattern.compile("\\s+");
    public static final String[][] STRINGS = new String[0][];

    static String[][] wordCountEngine(String document) {
        if (document.isEmpty()) {
            return STRINGS;
        }
        final String[] words = SPACES.split(PUNCTUATION.matcher(document).replaceAll(""));
        final Map<String, Integer> map = new LinkedHashMap<>();
        final Map<Integer, List<String>> map2 = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            map.merge(word, 1, Integer::sum);
        }

        for (Entry<String, Integer> e : map.entrySet()) {
            final String key = e.getKey();
            final Integer value = e.getValue();
            if (map2.containsKey(value)) {
                final List<String> list = map2.get(value);
                list.add(key);
            } else {
                map2.put(value, new ArrayList<>(Collections.singletonList(key)));
            }
        }

        final String[][] actual = new String[map.size()][];
        int idx = 0;

        for (int max = map.size(); max >= 0; max--) {
            if (map2.containsKey(max)) {
                final List<String> curr = map2.get(max);
                for (String word : curr) {
                    actual[idx++] = new String[] { word, String.valueOf(max) };
                }
            }
        }

        return actual;
    }

    public static void main(String[] args) {
        final String[][] res = wordCountEngine("practice makes perfect practice makes perfect yeah");
        for (String[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    private WordCountEngine() {}
}

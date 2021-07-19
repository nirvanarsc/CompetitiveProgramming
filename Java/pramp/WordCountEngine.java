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

    private static String[][] wordCountEngine(String document) {
        if (document.isEmpty()) {
            return STRINGS;
        }
        final String[] words = SPACES.split(PUNCTUATION.matcher(document).replaceAll(""));
        final Map<String, Integer> map = new LinkedHashMap<>();
        final Map<Integer, List<String>> map2 = new HashMap<>();
        final List<String[]> res = new ArrayList<>();

        for (String word : words) {
            map.merge(word.toLowerCase(), 1, Integer::sum);
        }
        for (Entry<String, Integer> e : map.entrySet()) {
            map2.computeIfAbsent(e.getValue(), v -> new ArrayList<>()).add(e.getKey());
        }
        for (int max = map.size(); max >= 0; max--) {
            for (String word : map2.getOrDefault(max, Collections.emptyList())) {
                res.add(new String[] { word, String.valueOf(max) });
            }
        }

        return res.toArray(STRINGS);
    }

    public static void main(String[] args) {
        final String[][] res = wordCountEngine("practice makes perfect practice makes perfect yeah");
        for (String[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}

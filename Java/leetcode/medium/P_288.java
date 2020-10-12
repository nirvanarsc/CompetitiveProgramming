package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_288 {

    public static class ValidWordAbbr {
        Map<String, Boolean> abbr;
        Set<String> words;

        public ValidWordAbbr(String[] dictionary) {
            abbr = new HashMap<>();
            words = new HashSet<>(Arrays.asList(dictionary));
            for (String w : words) {
                final String abbreviation = getAbbreviation(w);
                abbr.put(abbreviation, !abbr.containsKey(abbreviation));
            }
        }

        public boolean isUnique(String word) {
            final String abbreviation = getAbbreviation(word);
            final Boolean hasAbbr = abbr.get(abbreviation);
            return hasAbbr == null || (hasAbbr && words.contains(word));
        }

        private static String getAbbreviation(String w) {
            if (w.length() <= 2) {
                return w;
            }
            return w.charAt(0) + Integer.toString(w.length() - 2) + w.charAt(w.length() - 1);
        }
    }
}

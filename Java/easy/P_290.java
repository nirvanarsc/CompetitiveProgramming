package easy;

import java.util.HashMap;
import java.util.Map;

public class P_290 {

    public boolean wordPattern(String pattern, String str) {
        final Map<Character, String> charToWord = new HashMap<>();
        final Map<String, Character> wordToChar = new HashMap<>();
        final String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (!charToWord.getOrDefault(pattern.charAt(i), words[i]).equals(words[i])) {
                return false;
            }
            if (!wordToChar.getOrDefault(words[i], pattern.charAt(i)).equals(pattern.charAt(i))) {
                return false;
            }
            charToWord.put(pattern.charAt(i), words[i]);
            wordToChar.put(words[i], pattern.charAt(i));
        }
        return true;
    }
}

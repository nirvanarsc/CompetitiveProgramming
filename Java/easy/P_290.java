package easy;

import java.util.HashMap;
import java.util.Map;

public class P_290 {

    public boolean wordPattern(String pattern, String str) {
        final String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        final Map<Character, String> map1 = new HashMap<>();
        final Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!words[i].equals(map1.getOrDefault(pattern.charAt(i), words[i]))) {
                return false;
            }
            if (pattern.charAt(i) != map2.getOrDefault(words[i], pattern.charAt(i))) {
                return false;
            }
            map1.put(pattern.charAt(i), words[i]);
            map2.put(words[i], pattern.charAt(i));
        }
        return true;
    }
}

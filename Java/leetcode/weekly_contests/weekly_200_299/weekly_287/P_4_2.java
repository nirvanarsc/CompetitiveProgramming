package leetcode.weekly_contests.weekly_200_299.weekly_287;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_4_2 {

    class Encrypter {

        String[] d = new String[26];
        Map<String, Integer> count = new HashMap<>();

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            for (int i = 0; i < keys.length; i++) {
                d[keys[i] - 'a'] = values[i];
            }
            for (String d : dictionary) {
                count.merge(encrypt(d), 1, Integer::sum);
            }
        }

        public String encrypt(String word1) {
            final StringBuilder sb = new StringBuilder();
            for (char c : word1.toCharArray()) {
                sb.append(d[c - 'a']);
            }
            return sb.toString();
        }

        public int decrypt(String word2) {
            return count.getOrDefault(word2, 0);
        }
    }
}

package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class P_318 {

    public int maxProduct(String[] words) {
        final int[] bitmap = new int[words.length];
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                bitmap[i] |= 1 << (c - 'a');
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitmap[i] & bitmap[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public int maxProductComparisons(String[] words) {
        final Map<Integer, Integer> hashmap = new HashMap<>();
        int maxProd = 0;
        for (String word : words) {
            int bitmask = 0;
            for (char a : word.toCharArray()) {
                bitmask |= 1 << (a - 'a');
            }
            hashmap.merge(bitmask, word.length(), Math::max);
        }
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            for (Map.Entry<Integer, Integer> e : hashmap.entrySet()) {
                if ((entry.getKey() & e.getKey()) == 0) {
                    maxProd = Math.max(maxProd, entry.getValue() * e.getValue());
                }
            }
        }
        return maxProd;
    }
}

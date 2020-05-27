package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_30 {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return Collections.emptyList();
        }
        final List<Integer> list = new ArrayList<>();
        final Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        final int size = words[0].length();
        final int length = words.length;
        final int window = size * length;
        for (int i = 0; i < size; i++) {
            for (int start = i; start + window <= s.length(); start += size) {
                final String sub = s.substring(start, start + window);
                final Map<String, Integer> temp = new HashMap<>();
                int j = length;
                while (j > 0) {
                    final String word = sub.substring((j - 1) * size, j * size);
                    final int count = temp.getOrDefault(word, 0) + 1;
                    if (count > map.getOrDefault(word, 0)) {
                        break;
                    }
                    temp.put(word, count);
                    --j;
                }
                if (j == 0) {
                    list.add(start);
                } else {
                    start += size * (j - 1);
                }
            }
        }
        return list;
    }
}

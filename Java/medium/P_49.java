package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        for(String s:strs) {
            final char[] chars = s.toCharArray();
            Arrays.sort(chars);
            final String sorted = new String(chars);
            if(map.containsKey(sorted)) {
                map.get(sorted).add(s);
            } else {
                map.put(sorted, new ArrayList<>(Collections.singletonList(s)));
            }
        }

        return new ArrayList<>(map.values());
    }
}

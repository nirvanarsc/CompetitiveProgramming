package leetcode.weekly_contests.weekly_194;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_1487 {

    public String[] getFolderNamesSet(String[] names) {
        final Map<String, Integer> count = new HashMap<>();
        final Set<String> set = new HashSet<>();
        final String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (set.add(names[i])) {
                res[i] = names[i];
            } else {
                int g = count.getOrDefault(names[i], 0);
                String curr = names[i] + '(' + ++g + ')';
                while (!set.add(curr)) {
                    curr = names[i] + '(' + ++g + ')';
                }
                res[i] = curr;
                count.put(names[i], g);
            }
        }
        return res;
    }

    public String[] getFolderNames(String[] names) {
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            names[i] = getName(map, names[i]);
        }
        return names;
    }

    private static String getName(Map<String, Integer> map, String name) {
        if (map.containsKey(name)) {
            int n = map.get(name) + 1;
            while (map.containsKey(name + '(' + n + ')')) {
                n++;
            }
            map.put(name, n);
            name = getName(map, name + '(' + n + ')');
        } else {
            map.put(name, 0);
        }
        return name;
    }
}

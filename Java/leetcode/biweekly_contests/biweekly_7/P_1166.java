package leetcode.biweekly_contests.biweekly_7;

import java.util.HashMap;
import java.util.Map;

public class P_1166 {

    class FileSystem {
        Map<String, Integer> dir;

        FileSystem() {
            dir = new HashMap<>();
            dir.put("", 0);
        }

        public boolean create(String path, int value) {
            final int idx = path.lastIndexOf('/');
            final String parent = path.substring(0, idx);
            if (!dir.containsKey(parent) || dir.containsKey(path)) {
                return false;
            }
            dir.put(path, value);
            return true;
        }

        public int get(String path) {
            return dir.getOrDefault(path, -1);
        }
    }
}

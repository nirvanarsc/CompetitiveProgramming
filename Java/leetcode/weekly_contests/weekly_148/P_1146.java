package leetcode.weekly_contests.weekly_148;

import java.util.Collections;
import java.util.TreeMap;

@SuppressWarnings("unchecked")
public class P_1146 {

    // https://en.wikipedia.org/wiki/Persistent_data_structure#Fat_node
    static class SnapshotArray {
        TreeMap<Integer, Integer>[] tMap;
        int version;

        SnapshotArray(int length) {
            tMap = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                tMap[i] = new TreeMap<>(Collections.singletonMap(0, 0));
            }
        }

        public void set(int index, int val) {
            tMap[index].put(version, val);
        }

        public int snap() {
            return version++;
        }

        public int get(int index, int snap_id) {
            return tMap[index].floorEntry(snap_id).getValue();
        }
    }
}

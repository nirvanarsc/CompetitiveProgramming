package leetcode.weekly_contests.weekly_148;

import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({ "unchecked", "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_1146 {

    // https://en.wikipedia.org/wiki/Persistent_data_structure#Fat_node
    class SnapshotArray {
        TreeMap<Integer, Integer>[] tm;
        int snap;

        public SnapshotArray(int length) {
            tm = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                tm[i] = new TreeMap<>();
            }
        }

        public void set(int index, int val) {
            tm[index].put(snap, val);
        }

        public int snap() {
            return snap++;
        }

        public int get(int index, int snap_id) {
            final Map.Entry<Integer, Integer> e = tm[index].floorEntry(snap_id);
            return e == null ? 0 : e.getValue();
        }
    }
}

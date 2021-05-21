package binarysearch.weekly_42;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic" })
public class P_2 {

    class BooleanArray {
        Map<Integer, Integer> map;
        boolean def;

        BooleanArray() {
            map = new HashMap<>();
            def = false;
        }

        public void setTrue(int i) {
            map.put(i, 1);
        }

        public void setFalse(int i) {
            map.put(i, -1);
        }

        public void setAllTrue() {
            def = true;
            map.clear();
        }

        public void setAllFalse() {
            def = false;
            map.clear();
        }

        public boolean getValue(int i) {
            final Integer key = map.get(i);
            return key == null ? def : key > 0;
        }
    }
}

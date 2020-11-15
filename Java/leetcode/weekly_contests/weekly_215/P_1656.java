package leetcode.weekly_contests.weekly_215;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_1656 {

    class OrderedStream {

        String[] arr;
        int idx;

        OrderedStream(int n) {
            arr = new String[n];
        }

        public List<String> insert(int id, String value) {
            arr[id - 1] = value;
            final List<String> res = new ArrayList<>();
            while (idx < arr.length && arr[idx] != null) {
                res.add(arr[idx++]);
            }
            return res;
        }
    }
}

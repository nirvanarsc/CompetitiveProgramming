package leetcode.biweekly_contests.biweekly_40;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_1670 {

    class FrontMiddleBackQueue {

        List<Integer> list;

        FrontMiddleBackQueue() {
            list = new ArrayList<>(1000);
        }

        public void pushFront(int val) {
            list.add(0, val);
        }

        public void pushMiddle(int val) {
            list.add(list.size() / 2, val);
        }

        public void pushBack(int val) {
            list.add(val);
        }

        public int popFront() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove(0);
        }

        public int popMiddle() {
            if (list.isEmpty()) {
                return -1;
            }
            final int mid = (list.size() / 2) - (list.size() % 2 == 0 ? 1 : 0);
            return list.remove(mid);
        }

        public int popBack() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove(list.size() - 1);
        }
    }
}

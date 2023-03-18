package leetcode.biweekly_contests.biweekly_0_99.biweekly_95;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_2 {

    class DataStream {

        int curr;
        int value;
        int k;
        Deque<Integer> dq;

        public DataStream(int value, int k) {
            curr = 0;
            this.value = value;
            this.k = k;
            dq = new ArrayDeque<>();
        }

        public boolean consec(int num) {
            dq.addFirst(num);
            if (num == value) {
                curr++;
            }
            if (dq.size() > k) {
                final int pop = dq.removeLast();
                if (pop == value) {
                    curr--;
                }
            }
            return curr == k;
        }
    }
}

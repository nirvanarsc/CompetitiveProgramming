package weekly_167;

import utils.DataStructures.ListNode;

public class P_1290 {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res <<= 1;
            if (head.val == 1) {
                res |= 1;
            }
            head = head.next;
        }
        return res;
    }
}

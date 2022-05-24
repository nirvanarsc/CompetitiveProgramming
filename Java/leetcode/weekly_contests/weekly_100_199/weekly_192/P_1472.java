package leetcode.weekly_contests.weekly_100_199.weekly_192;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class P_1472 {

    static class BrowserHistoryAL {
        int idx;
        List<String> history;

        BrowserHistoryAL(String homepage) {
            history = new ArrayList<>();
            history.add(homepage);
        }

        public void visit(String url) {
            history = history.subList(0, idx + 1);
            history.add(url);
            idx++;
        }

        public String back(int steps) {
            idx = Math.max(0, idx - steps);
            return history.get(idx);
        }

        public String forward(int steps) {
            idx = Math.min(history.size() - 1, idx + steps);
            return history.get(idx);
        }
    }

    static class BrowserHistory {

        static class ListNode {
            String url;
            ListNode prev;
            ListNode next;

            ListNode(String url) {
                this.url = url;
            }
        }

        ListNode head;

        BrowserHistory(String homepage) {
            head = new ListNode(homepage);
        }

        public void visit(String url) {
            head.next = new ListNode(url);
            head.next.prev = head;
            head = head.next;
        }

        public String back(int steps) {
            for (int i = 0; i < steps && head.prev != null; i++) {
                head = head.prev;
            }
            return head.url;
        }

        public String forward(int steps) {
            for (int i = 0; i < steps && head.next != null; i++) {
                head = head.next;
            }
            return head.url;
        }
    }
}

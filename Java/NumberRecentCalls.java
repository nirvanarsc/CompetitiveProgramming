import java.util.LinkedList;

public final class NumberRecentCalls {

    /*
    LinkedList<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        if (t == 0) {
            return 0;
        }
        queue.add(t);
        while(queue.peekFirst() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
    */

    static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(ping(1));
        System.out.println(ping(100));
        System.out.println(ping(3001));
        System.out.println(ping(3002));
    }

    public static int ping(int t) {
        if (t == 0) {
            return 0;
        }
        queue.add(t);
        while (queue.peekFirst() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    private NumberRecentCalls() {}
}

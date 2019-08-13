import java.util.PriorityQueue;
import java.util.Stack;

public final class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[] { 2, 2, 3, 3, 3 }));
        System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
        System.out.println(lastStoneWeightPQ(new int[] { 2, 2, 3, 3, 3 }));
        System.out.println(lastStoneWeightPQ(new int[] { 2, 7, 4, 1, 8, 1 }));
    }

    public static int lastStoneWeight(int[] stones) {
        final Stack<Integer> stack = new Stack<>();
        final int[] map = new int[1001];
        for (int i : stones) { map[i]++; }
        for (int i = 0; i < 1001; i++) {
            if (map[i] != 0) {
                while (map[i]-- > 0) { stack.push(i); }
            }
        }
        while (stack.size() > 1) {
            final int top = stack.pop();
            if (top == stack.peek()) {
                stack.pop();
            } else {
                final int next = stack.pop();
                final int diff = top - next;
                if (stack.isEmpty() || stack.peek() <= diff) {
                    stack.push(diff);
                } else {
                    final Stack<Integer> temp = new Stack<>();
                    while (!stack.isEmpty() && stack.peek() > diff) {
                        temp.push(stack.pop());
                    }
                    stack.push(diff);
                    while (!temp.isEmpty()) {
                        stack.push(temp.pop());
                    }
                }
            }
        }
        return stack.empty() ? 0 : stack.pop();
    }

    public static int lastStoneWeightPQ(int[] stones) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a : stones) {
            pq.offer(a);
        }
        for (int i = 0; i < stones.length - 1; ++i) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }

    private LastStoneWeight() {}
}

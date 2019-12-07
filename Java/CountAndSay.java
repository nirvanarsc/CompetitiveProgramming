import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public final class CountAndSay {

    public static String countAndSay(int n) {
        final Deque<Integer> deque = new LinkedList<>(Collections.singletonList(1));

        for (int i = 2; i <= n; i++) {
            int size = deque.size();
            while (size > 0) {
                final Integer integer = deque.pollFirst();
                Integer count = 1;
                size--;
                while (size > 0 && deque.peekFirst().equals(integer)) {
                    deque.pollFirst();
                    count++;
                    size--;
                }
                deque.addLast(count);
                deque.addLast(integer);
            }
        }

        final StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(x -> System.out.println(countAndSay(x)));
    }

    private CountAndSay() {}
}

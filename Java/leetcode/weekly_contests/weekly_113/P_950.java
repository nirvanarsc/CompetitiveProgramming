package leetcode.weekly_contests.weekly_113;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_950 {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        final Deque<Integer> deque = new ArrayDeque<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }
            deque.addFirst(deck[i]);
        }
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}

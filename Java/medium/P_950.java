package medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public final class P_950 {

    public static int[] deckRevealedIncreasing(int[] deck) {
        final Deque<Integer> deque = new LinkedList<>();
        Arrays.sort(deck);
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }
            deque.addFirst(deck[i]);
        }
        for (int i = 0; i < deck.length; i++) {
            deck[i] = deque.removeFirst();
        }
        return deck;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[] { 17, 13, 11, 2, 3, 5, 7 })));
    }

    private P_950() {}
}

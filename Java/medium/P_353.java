package medium;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_353 {

    public static class SnakeGame {
        Set<Integer> set;
        Deque<Integer> body;
        int score;
        int[][] food;
        int foodIndex;
        int width;
        int height;

        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            set = new HashSet<>(Collections.singleton(0));
            body = new ArrayDeque<>(Collections.singleton(0));
        }

        public int move(String direction) {
            if (score == -1) {
                return -1;
            }
            int rowHead = body.getFirst() / width;
            int colHead = body.getFirst() % width;
            switch (direction) {
                case "U":
                    rowHead--;
                    break;
                case "D":
                    rowHead++;
                    break;
                case "L":
                    colHead--;
                    break;
                default:
                    colHead++;
            }
            final int head = rowHead * width + colHead;
            set.remove(body.peekLast());
            if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
                return score = -1;
            }
            set.add(head);
            body.addFirst(head);
            if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
                set.add(body.peekLast());
                foodIndex++;
                return ++score;
            }
            body.removeLast();
            return score;
        }
    }
}

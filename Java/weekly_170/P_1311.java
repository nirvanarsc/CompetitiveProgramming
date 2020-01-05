package weekly_170;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_1311 {
    static class Node {
        int val;
        List<Node> adjacent = new ArrayList<>();

        Node(int val) {
            this.val = val;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,
                                               int[][] friends,
                                               int id,
                                               int level) {
        final Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            nodes.put(i, new Node(i));
        }
        for (int i = 0; i < friends.length; i++) {
            final Node node = nodes.get(i);
            for (int j = 0; j < friends[i].length; j++) {
                node.adjacent.add(nodes.get(friends[i][j]));
            }
        }
        final Node curr = nodes.get(id);
        final Deque<Node> queue = new LinkedList<>();
        final Set<Node> seen = new HashSet<>();
        queue.offerLast(curr);
        while (level-- > 0) {
            int newLevel = queue.size();
            while (newLevel-- > 0) {
                final Node node = queue.removeFirst();
                seen.add(node);
                for (Node n : node.adjacent) {
                    if (!seen.contains(n)) {
                        queue.offerLast(n);
                    }
                }
            }
        }
        final Map<String, Integer> map = new HashMap<>();
        for (Node n : queue) {
            if (!seen.contains(n)) {
                seen.add(n);
                for (String s : watchedVideos.get(n.val)) {
                    map.merge(s, 1, Integer::sum);
                }
            }
        }
        final List<String> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(a).equals(map.get(b))
                            ? a.compareTo(b)
                            : Integer.compare(map.get(a), map.get(b)));
        return list;
    }

    public List<String> watchedVideosByFriends2(List<List<String>> watchedVideos,
                                                int[][] friends,
                                                int id,
                                                int level) {
        final Deque<Integer> queue = new ArrayDeque<>();
        final HashSet<Integer> seen = new HashSet<>();
        queue.add(id);
        seen.add(id);
        for (int i = 0; i < level; i++) {
            for (int j = queue.size(); j > 0; j--) {
                for (int friend : friends[queue.remove()]) {
                    if (!seen.contains(friend)) {
                        seen.add(friend);
                        queue.add(friend);
                    }
                }
            }
        }
        final Map<String, Integer> map = new HashMap<>();
        for (int i : queue) {
            for (String video : watchedVideos.get(i)) {
                map.merge(video, 1, Integer::sum);
            }
        }
        final List<String> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(a).equals(map.get(b))
                            ? a.compareTo(b)
                            : Integer.compare(map.get(a), map.get(b)));
        return list;
    }
}

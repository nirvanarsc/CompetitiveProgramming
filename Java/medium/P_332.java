package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_332 {

    public List<String> findItinerary(List<List<String>> tickets) {
        final Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        final List<String> res = new ArrayList<>();
        recurse("JFK", res, graph);
        Collections.reverse(res);
        return res;
    }

    private static void recurse(String currCity, List<String> itinerary, Map<String, PriorityQueue<String>> g) {
        if (g.get(currCity) == null || g.get(currCity).isEmpty()) {
            itinerary.add(currCity);
            return;
        }

        final PriorityQueue<String> queue = g.get(currCity);
        while (queue != null && !queue.isEmpty()) {
            final String next = queue.poll();
            recurse(next, itinerary, g);
        }

        itinerary.add(currCity);
    }
}

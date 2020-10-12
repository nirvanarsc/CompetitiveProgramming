package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_332 {

    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new ArrayList<>();

    // https://en.wikipedia.org/wiki/Eulerian_path
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), v -> new PriorityQueue<>()).add(ticket.get(1));
        }
        visit("JFK");
        Collections.reverse(route);
        return route;
    }

    private void visit(String airport) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            visit(targets.get(airport).remove());
        }
        route.add(airport);
    }
}

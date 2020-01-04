package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        final double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }

        return result;
    }

    private static double getPathWeight(String start,
                                        String end,
                                        Set<String> visited,
                                        Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                final double productWeight = getPathWeight(neighbour.getKey(), end, visited, graph);
                if (Double.compare(productWeight, -1.0) != 0) {
                    return neighbour.getValue() * productWeight;
                }
            }
        }

        return -1.0;
    }

    private static Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        final Map<String, Map<String, Double>> graph = new HashMap<>();
        String dividend, divisor;

        for (int i = 0; i < equations.size(); i++) {
            dividend = equations.get(i).get(0);
            divisor = equations.get(i).get(1);
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.get(dividend).put(divisor, values[i]);
            graph.putIfAbsent(divisor, new HashMap<>());
            graph.get(divisor).put(dividend, 1 / values[i]);
        }

        return graph;
    }
}

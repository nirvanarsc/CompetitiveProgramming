package leetcode.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_690 {

    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        final Map<Integer, Employee> g = new HashMap<>();
        for (Employee e : employees) {
            g.put(e.id, e);
        }
        return dfs(g, id);
    }

    private static int dfs(Map<Integer, Employee> g, int id) {
        int res = g.get(id).importance;
        for (int next : g.get(id).subordinates) {
            res += dfs(g, next);
        }
        return res;
    }
}

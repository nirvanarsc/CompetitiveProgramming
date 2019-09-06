import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportance {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    // BFS
    public int getImportance(List<Employee> employees, int id) {
        final Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        int res = 0;
        final Queue<Employee> q = new LinkedList<>();
        q.offer(map.get(id));

        while (!q.isEmpty()) {
            final Employee curr = q.poll();
            res += curr.importance;
            for (int i : curr.subordinates) {
                q.offer(map.get(i));
            }
        }

        return res;
    }

    // DFS
    public static int getImportanceDFS(List<Employee> employees, int id) {
        final Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return getImportanceHelper(map, id);
    }

    private static int getImportanceHelper(Map<Integer, Employee> map, int rootId) {
        final Employee root = map.get(rootId);
        int total = root.importance;
        for (int i : root.subordinates) {
            total += getImportanceHelper(map, i);
        }
        return total;
    }
}

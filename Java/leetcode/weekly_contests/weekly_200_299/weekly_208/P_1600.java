package leetcode.weekly_contests.weekly_200_299.weekly_208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_1600 {

    class ThroneInheritance {
        private class Node {
            String name;
            List<Node> children = new ArrayList<>();
            boolean alive = true;

            Node(String name) {
                this.name = name;
            }
        }

        Map<String, Node> map = new HashMap<>();
        Node king;

        ThroneInheritance(String kingName) {
            king = new Node(kingName);
            map.put(kingName, king);
        }

        public void birth(String parentName, String childName) {
            final Node person = new Node(childName);
            map.get(parentName).children.add(person);
            map.put(childName, person);
        }

        public void death(String name) {
            map.get(name).alive = false;
        }

        public List<String> getInheritanceOrder() {
            final List<String> res = new ArrayList<>();
            dfs(king, res);
            return res;
        }

        private void dfs(Node curr, List<String> res) {
            if (curr.alive) {
                res.add(curr.name);
            }
            for (Node child : curr.children) {
                dfs(child, res);
            }
        }
    }
}

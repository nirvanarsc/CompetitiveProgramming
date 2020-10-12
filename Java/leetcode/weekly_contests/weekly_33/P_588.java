package leetcode.weekly_contests.weekly_33;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class P_588 {

    static class FileSystem {

        static class Node {
            int type;
            StringBuilder content = new StringBuilder();
            Node[] children = new Node[27];
        }

        Node root;

        FileSystem() {
            root = new Node();
            root.type = 1;
            root.children[26] = new Node();
        }

        public List<String> ls(String path) {
            final List<String> list = new ArrayList<>();
            if ("/".equals(path)) {
                dfs(list, root.children[26], new StringBuilder());
                return list;
            }

            final Node node = traverse(path, 1);

            if (node.type == 2) {
                int k = path.length() - 1;
                while (k >= 0 && path.charAt(k) != '/') {
                    k--;
                }
                list.add(path.substring(k + 1));
            } else {
                if (node.children[26] == null) {
                    return list;
                }
                dfs(list, node.children[26], new StringBuilder());
            }
            return list;
        }

        public void mkdir(String path) {
            traverse(path, 1);
        }

        public void addContentToFile(String filePath, String content) {
            final Node node = traverse(filePath, 2);
            node.content.append(content);
        }

        public String readContentFromFile(String filePath) {
            final Node node = traverse(filePath, 2);
            return node.content.toString();
        }

        private Node traverse(String s, int type) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                final int next = s.charAt(i) == '/' ? 26 : s.charAt(i) - 'a';
                if (node.children[next] == null) {
                    node.children[next] = new Node();
                }
                node = node.children[next];
                if (i + 1 < s.length() && s.charAt(i + 1) == '/') {
                    node.type = 1;
                }
            }
            if (node.type == 0) {
                node.type = type;
            }
            return node;
        }

        private static void dfs(List<String> list, Node root, StringBuilder sb) {
            if (root.type > 0) {
                list.add(sb.toString());
            }
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    sb.append((char) ('a' + i));
                    dfs(list, root.children[i], sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}


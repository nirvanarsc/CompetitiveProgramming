import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/discuss/interview-question/643158/google-phone-faulty-keyboard
// https://leetcode.com/discuss/interview-experience/778039/google-phone-interview-rejected
public final class FaultyKeyboard {

    static class Trie {
        Map<Character, Trie> children = new HashMap<>();
        String word;
    }

    private static void dfs(String s, int i, Trie root, Trie curr,
                            List<String> path,
                            List<List<String>> result) {
        if (i == s.length()) {
            if (curr.word != null) {
                path.add(curr.word);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        final char c = s.charAt(i);
        if (curr.children.containsKey(c)) {
            dfs(s, i + 1, root, curr.children.get(c), path, result);
        } else if (c == ' ') {
            if (curr.word != null) {
                path.add(curr.word);
                dfs(s, i + 1, root, root, path, result);
                path.remove(path.size() - 1);
            }
            if (curr.children.containsKey('e')) {
                dfs(s, i + 1, root, curr.children.get('e'), path, result);
            }
        }
    }

    private static Trie buildTrie(List<String> dict) {
        final Trie root = new Trie();
        for (String word : dict) {
            insert(root, word);
        }
        return root;
    }

    private static void insert(Trie root, String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new Trie());
            curr = curr.children.get(c);
        }
        curr.word = word;
    }

    private static List<List<String>> faultyKeyboard(String sentence, List<String> dictionary) {
        final List<List<String>> result = new ArrayList<>();
        final Trie root = buildTrie(dictionary);
        dfs(sentence, 0, root, root, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(faultyKeyboard("can s r n ",
                                          Arrays.asList("can", "canes", "serene", "rene", "sam")));
        System.out.println(faultyKeyboard("I lik  to  xplor  univ rs ",
                                          Arrays.asList("I", "like", "explore", "to", "universe", "rse")));
    }
}

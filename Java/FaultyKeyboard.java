import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/discuss/interview-question/643158/google-phone-faulty-keyboard
public class FaultyKeyboard {

    static class Trie {
        Trie[] children = new Trie[52];
        boolean isWord;
    }

    List<String> answer = new ArrayList<>();
    Trie root;
    String input;
    int longestWord;

    private void insert(String str) {
        Trie curr = root;
        for (char c : str.toCharArray()) {
            final int id = c <= 'Z' ? c - 'A' : c - 'a' + 26;
            if (curr.children[id] == null) {
                curr.children[id] = new Trie();
            }
            curr = curr.children[id];
        }
        curr.isWord = true;
    }

    private List<Integer> search(int start, int end) {
        Trie curr = root;
        final List<Integer> res = new ArrayList<>();
        for (int i = start; i < end; i++) {
            final int id;
            if (input.charAt(i) == ' ') {
                id = 'e' - 'a' + 26;
            } else if (input.charAt(i) <= 'Z') {
                id = input.charAt(i) - 'A';
            } else {
                id = input.charAt(i) - 'a' + 26;
            }
            if (curr.children[id] == null) {
                return res;
            }
            curr = curr.children[id];
            if (curr.isWord) {
                res.add(i);
            }
        }
        return res;
    }

    private void backTrack(int start, int end, String curr) {
        if (start == end) {
            answer.add(curr);
            return;
        }
        backTrack(start + 1, end, curr + input.charAt(start));
        for (int jump : search(start, Math.min(end, start + longestWord))) {
            final String newStr = input.substring(start, jump + 1).replace(' ', 'e');
            backTrack(jump + 1, end, curr + newStr);
        }
    }

    public static void main(String[] args) {
        final FaultyKeyboard faultyKeyboard = new FaultyKeyboard();
        faultyKeyboard.root = new Trie();
        faultyKeyboard.input = "I lik   to   xplor   univ rs ";
        for (String w : Arrays.asList("like", "explore", "toe", "universe", "rse")) {
            faultyKeyboard.insert(w);
            faultyKeyboard.longestWord = Math.max(faultyKeyboard.longestWord, w.length());
        }
        faultyKeyboard.backTrack(0, faultyKeyboard.input.length(), "");
        for (String ans : faultyKeyboard.answer) {
            System.out.println(ans);
        }
    }
}

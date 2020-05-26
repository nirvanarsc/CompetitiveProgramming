package easy;

public class P_14 {

    static class Trie {
        Trie[] children = new Trie[26];
        char firstChar = '*';
        int size = 1;
    }

    public String longestCommonPrefixTrie(String[] strings) {
        final Trie root = new Trie();
        for (String w : strings) {
            Trie iter = root;
            for (char c : w.toCharArray()) {
                if (iter.firstChar == c) {
                    iter.size++;
                }
                iter.firstChar = c;
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new Trie();
                }
                iter = iter.children[c - 'a'];
            }
        }
        final StringBuilder sb = new StringBuilder();
        Trie iter = root;
        while (iter.firstChar != '*' && iter.size == strings.length) {
            sb.append(iter.firstChar);
            iter = iter.children[iter.firstChar - 'a'];

        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        String pre = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (!strings[i].startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }
}

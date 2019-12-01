public final class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strings) {
        final StringBuilder res = new StringBuilder();
        int i = 0;

        outer:
        while (strings.length > 0 && i < strings[0].length()) {
            final char curr = strings[0].charAt(i);
            for (String s : strings) {
                if (i >= s.length() || s.charAt(i) != curr) {
                    break outer;
                }
            }
            res.append(curr);
            i++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println(longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
        System.out.println(longestCommonPrefix(new String[] { "dog" }));
        System.out.println(longestCommonPrefix(new String[] { "aa", "a" }));
    }

    private LongestCommonPrefix() {}
}

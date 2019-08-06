public final class ShortestDistanceToCharacter {

    public static void main(String[] args) {
        for (int i : shortestToChar("loveleetcode", 'e')) { System.out.print(i); }
        System.out.println();
        for (int i : shortestToChar("aaab", 'b')) { System.out.print(i); }
        System.out.println();
        for (int i : shortestToChar("aaba", 'b')) { System.out.print(i); }
        System.out.println();
    }

    public static int[] shortestToChar(String s, char c) {
        final int n = s.length();
        final int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == c) { pos = i; }
            res[i] = i - pos;
        }
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == c) { pos = i; }
            res[i] = Math.min(res[i], Math.abs(i - pos));
        }
        return res;
    }

    private ShortestDistanceToCharacter() {}
}

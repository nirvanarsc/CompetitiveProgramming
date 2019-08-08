public final class NumberLinesWriteString {

    public static void main(String[] args) {
        final int[] widths = {
                4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10
        };
        for (int i : numberOfLines(widths, "bbbcccdddaaa")) {
            System.out.println(i);
        }
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int currLine = 0;
        int lines = 1;
        for (int i = 0; i < s.length(); i++) {
            currLine += widths[s.charAt(i) - 'a'];
            if (currLine > 100) {
                currLine = 0;
                lines++;
                i--;
            }
        }

        return new int[] { lines, currLine };
    }

    private NumberLinesWriteString() {}
}

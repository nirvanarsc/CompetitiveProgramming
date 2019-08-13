import java.util.ArrayList;
import java.util.List;

public final class KeyboardRow {

    public static final String[] STRINGS = {};

    public static void main(String[] args) {
        for (String s : findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" })) {
            System.out.println(s);
        }
    }

    public static String[] findWords(String[] words) {
        final String row1 = "qwertyuiopQWERTYUIOP";
        final String row2 = "asdfghjklASDFGHJKL";
        final String row3 = "zxcvbnmZXCVBNM";
        final List<String> res = new ArrayList<>();

        for (String s : words) {
            if (row1.indexOf(s.charAt(0)) > -1) {
                checkRow(row1, s, res);
            } else if (row2.indexOf(s.charAt(0)) > -1) {
                checkRow(row2, s, res);
            } else { checkRow(row3, s, res); }
        }

        return res.toArray(STRINGS);
    }

    private static void checkRow(String row, String s, List<String> res) {
        for (int i = 1; i < s.length(); i++) {
            if (row.indexOf(s.charAt(i)) == -1) {
                return;
            }
        }
        res.add(s);
    }

    private KeyboardRow() {}
}

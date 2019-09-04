import java.util.regex.Pattern;

public final class ShortestCompletingWord {

    private static final Pattern COMPILE = Pattern.compile("[^a-z]");

    public static void main(String[] args) {
        final String licensePlate = "1s3 PSt";
        final String[] words = { "step", "steps", "stripe", "stepple" };
        System.out.println(shortestCompletingWord(licensePlate, words));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        final char[] chars = COMPILE.matcher(licensePlate.toLowerCase()).replaceAll("").toCharArray();

        String res = new String(new char[1001]);

        main:
        for (String s : words) {
            final char[] curr = s.toCharArray();
            for (char c : chars) {
                if (!contains(c, curr)) { continue main; }
            }
            res = s.length() < res.length() ? s : res;
        }

        return res;
    }

    private static boolean contains(char c, char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (c == arr[i]) {
                arr[i] = 0;
                return true;
            }
        }
        return false;
    }

    private ShortestCompletingWord() {}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UncommonWordsFromSentences {

    public static final String[] STRINGS = {};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("s z z z s", "s z ejt")));
    }

    public static String[] uncommonFromSentences(String a, String b) {
        final List<String> res = new ArrayList<>();
        final Map<String, Integer> map = new HashMap<>();

        for (String s : (a + ' ' + b).split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                res.add(s);
            }
        }

        return res.toArray(STRINGS);
    }

    private UncommonWordsFromSentences() {}
}

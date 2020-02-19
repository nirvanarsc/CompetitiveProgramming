package weekly_147;

import java.util.HashMap;
import java.util.Map;

public class P_1138 {

    public String alphabetBoardPath(String target) {
        final Map<Character, int[]> map = new HashMap<>();
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alphabet.length(); i++) {
            map.put(alphabet.charAt(i), new int[] { i / 5, i % 5 });
        }
        final StringBuilder sb = new StringBuilder();
        int r = 0;
        int c = 0;
        for (char t : target.toCharArray()) {
            final int[] dest = map.get(t);
            while (r > dest[0]) { r--; sb.append('U'); }
            while (c < dest[1]) { c++; sb.append('R'); }
            while (c > dest[1]) { c--; sb.append('L'); }
            while (r < dest[0]) { r++; sb.append('D'); }
            sb.append('!');
        }
        return sb.toString();
    }
}

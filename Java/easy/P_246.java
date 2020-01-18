package easy;

import java.util.HashMap;
import java.util.Map;

public class P_246 {

    public boolean isStrobogrammatic(String num) {
        final Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        final StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            if (!map.containsKey(num.charAt(i))) {
                return false;
            }
            sb.append(map.get(num.charAt(i)));
        }
        return num.equals(sb.toString());
    }
}

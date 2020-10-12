package leetcode.weekly_contests.weekly_73;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P_791 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String customSortString(String S, String T) {
        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        return IntStream.range(0, T.length())
                        .mapToObj(T::charAt)
                        .sorted((a, b) -> {
                            if (map.containsKey(a) && map.containsKey(b)) {
                                return Integer.compare(map.get(a), map.get(b));
                            }
                            if (map.containsKey(a)) {
                                return -1;
                            }
                            if (map.containsKey(b)) {
                                return 1;
                            }
                            return Character.compare(a, b);
                        })
                        .map(String::valueOf)
                        .collect(Collectors.joining());
    }
}

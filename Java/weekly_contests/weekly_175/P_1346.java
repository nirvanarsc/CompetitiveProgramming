package weekly_contests.weekly_175;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_1346 {

    public boolean checkIfExistSet(int[] arr) {
        final Set<Integer> hs = new HashSet<>();
        for (int a : arr) {
            hs.add(a);
        }
        for (int n : hs) {
            if (n != 0 && hs.contains(n * 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfExist(int[] arr) {
        final Map<Integer, Set<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.putIfAbsent(arr[i], new HashSet<>());
            hashMap.get(arr[i]).add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(2 * arr[i])) {
                if (arr[i] == 0) {
                    final Set<Integer> integers = hashMap.get(2 * arr[i]);
                    integers.remove(i);
                    if (!integers.isEmpty()) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}

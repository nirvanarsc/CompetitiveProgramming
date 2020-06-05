package easy;

import java.util.HashSet;
import java.util.Set;

public class P_217 {

    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}

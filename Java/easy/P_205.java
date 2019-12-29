package easy;

import java.util.Arrays;

public class P_205 {

    public boolean isIsomorphic(String s, String t) {
        final int[] m1 = new int[256];
        final int[] m2 = new int[256];
        Arrays.fill(m1, -1);
        Arrays.fill(m2, -1);
        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = m2[t.charAt(i)] = i;
        }
        return true;
    }
}

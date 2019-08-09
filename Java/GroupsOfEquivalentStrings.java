import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class GroupsOfEquivalentStrings {

    public static void main(String[] args) {
        System.out.println(numSpecialEquivGroups(new String[] { "a", "b", "c", "a", "c", "c" }));
        System.out.println(numSpecialEquivGroups(new String[] { "aa", "bb", "ab", "ba" }));
        System.out.println(numSpecialEquivGroups(new String[] { "abc", "acb", "bac", "bca", "cab", "cba" }));
        System.out.println(numSpecialEquivGroups(new String[] { "abcd", "cdab", "adcb", "cbad" }));
    }

    public static int numSpecialEquivGroups(String[] a) {
        final Set<String> set = new HashSet<>();
        for (String s : a) {
            final int[] odd = new int[26];
            final int[] even = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) { odd[s.charAt(i) - 'a']++; } else { even[s.charAt(i) - 'a']++; }
            }
            final String sig = Arrays.toString(odd) + Arrays.toString(even);
            set.add(sig);
        }
        return set.size();
    }

    private GroupsOfEquivalentStrings() {}
}

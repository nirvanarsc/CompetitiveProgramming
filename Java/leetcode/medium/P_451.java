package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_451 {

    public String frequencyBucketSort(String s) {
        final int[] freq = new int[128];
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        for (int i = 0; i < 128; i++) {
            if (freq[i] != 0) {
                list.add(i);
            }
        }
        list.sort((a, b) -> Integer.compare(freq[b], freq[a]));
        final StringBuilder sb = new StringBuilder();
        for (int i : list) {
            while (freq[i]-- > 0) {
                sb.append((char) i);
            }
        }
        return sb.toString();
    }

    public String frequencySort(String s) {
        final Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        final Map<Character, Integer> freq = new HashMap<>();
        for (Character c : arr) {
            freq.merge(c, 1, Integer::sum);
        }
        Arrays.sort(arr, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return Character.compare(a, b);
            }
            return Integer.compare(freq.get(b), freq.get(a));
        });
        final StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}

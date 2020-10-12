package leetcode.biweekly_contests.biweekly_23;

public class P_1400 {

    public boolean canConstruct(String s, int k) {
        final int [] map = new int[26];
        for(char c: s.toCharArray()) {
            map[c-'a']++;
        }
        int odd = 0;
        for(int i=0; i<26; i++) {
            if(map[i] % 2 != 0) {
                odd++;
            }
        }
        return s.length() >= k && odd <= k;
    }
}

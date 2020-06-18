package easy;

public class P_345 {

    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        final String vowels = "aeiouAEIOU";
        final char[] string = s.toCharArray();
        while (start < end) {
            if (vowels.indexOf(string[start]) == -1) {
                start++;
            } else if (vowels.indexOf(string[end]) == -1) {
                end--;
            } else {
                final char t = string[start];
                string[start] = string[end];
                string[end] = t;
                start++;
                end--;
            }
        }
        return new String(string);
    }
}

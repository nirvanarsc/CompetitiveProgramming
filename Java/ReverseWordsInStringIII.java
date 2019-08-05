public final class ReverseWordsInStringIII {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        final char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) { reverseWord(chars, start, i); }
            if (chars[i] == ' ') {
                reverseWord(chars, start, i - 1);
                start = i + 1;
            }
        }

        return new String(chars);
    }

    private static void reverseWord(char[] chars, int start, int end) {
        while (start < end) {
            final char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    private ReverseWordsInStringIII() {}
}

import java.util.Stack;

public final class RemoveAdjacentDuplicates {

    public static final Character[] CHARACTERS = new Character[0];

    public static void main(String[] args) {
        System.out.println(removeDuplicates("dabbaczxfmnnmd"));
        System.out.println(removeDuplicates2("dabbaczxfmnnmd"));
    }

    public static String removeDuplicates(String s) {
        final Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        final StringBuilder res = new StringBuilder();
        stack.forEach(res::append);
        return res.toString();
    }

    // Optimized
    public static String removeDuplicates2(String s) {
        int i = 0;
        final int n = s.length();
        final char[] stack = new char[n];
        for (int j = 0; j < n; ++j) {
            if (i > 0 && stack[i - 1] == s.charAt(j)) {
                --i;
            } else {
                stack[i++] = s.charAt(j);
            }
        }
        return new String(stack, 0, i);
    }

    private RemoveAdjacentDuplicates() {}
}

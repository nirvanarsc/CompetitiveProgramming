import java.util.Stack;

public class RemoveOutermostParentheses {
    private static String removeOuterParentheses(String S) {
        Stack<Character> openParentheses = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (!openParentheses.empty()) {
                    res.append(S.charAt(i));
                }
                openParentheses.push(S.charAt(i));
            }
            if (S.charAt(i) == ')') {
                openParentheses.pop();
                if (!openParentheses.empty()) {
                    res.append(S.charAt(i));
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}

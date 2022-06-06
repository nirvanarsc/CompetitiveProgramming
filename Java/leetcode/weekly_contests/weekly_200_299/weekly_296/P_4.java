package leetcode.weekly_contests.weekly_200_299.weekly_296;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_4 {

    class TextEditor {

        StringBuilder sb;
        int idx;

        public TextEditor() {
            sb = new StringBuilder();
            idx = 0;
        }

        public void addText(String text) {
            sb.insert(idx, text);
            idx += text.length();
        }

        public int deleteText(int k) {
            final int max = Math.max(0, idx - k);
            sb.delete(max, idx);
            final int res = idx - max;
            idx = max;
            return res;
        }

        public String cursorLeft(int k) {
            if (idx - k < 0) {
                idx = 0;
                return "";
            }
            idx -= k;
            return sb.substring(Math.max(0, idx - 10), idx);
        }

        public String cursorRight(int k) {
            if (idx + k > sb.length()) {
                idx = sb.length();
                return sb.substring(Math.max(0, idx - 10), idx);
            }
            idx += k;
            return sb.substring(Math.max(0, idx - 10), idx);
        }
    }
}

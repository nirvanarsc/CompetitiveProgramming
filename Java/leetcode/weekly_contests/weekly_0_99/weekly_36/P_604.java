package leetcode.weekly_contests.weekly_0_99.weekly_36;

@SuppressWarnings("unused")
public class P_604 {

    static class StringIterator {
        char c;
        int index;
        int count;
        String str;

        StringIterator(String compressedString) {
            str = compressedString;
            setNext(str);
        }

        public char next() {
            if (hasNext()) {
                count--;
                return c;
            }
            return ' ';
        }

        public boolean hasNext() {
            if (count > 0) {
                return true;
            }
            return setNext(str);
        }

        private boolean setNext(String str) {
            if (index == str.length()) {
                return false;
            }
            c = str.charAt(index);
            int j = index + 1;
            while (j < str.length() && Character.isDigit(str.charAt(j))) {
                j++;
            }
            count = Integer.parseInt(str.substring(index + 1, j));
            index = j;
            return true;
        }
    }
}



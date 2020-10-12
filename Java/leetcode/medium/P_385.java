package leetcode.medium;

public class P_385 {

    static class NestedInteger {
        int value;
        NestedInteger ni;

        NestedInteger() { }

        NestedInteger(int value) {
            this.value = value;
        }

        void add(NestedInteger ni) {
            this.ni = ni;
        }

        void setInteger(int value) {
            this.value = value;
        }
    }

    int i;

    public NestedInteger deserialize(String s) {
        return getNestedInteger(s, new NestedInteger());
    }

    public NestedInteger getNestedInteger(String s, NestedInteger n) {
        StringBuilder str = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                if (i == 0) {
                    i++;
                    continue;
                }
                i++;
                n.add(getNestedInteger(s, new NestedInteger()));
            } else if (s.charAt(i) == ']') {
                if (str.length() > 0) {
                    n.add(new NestedInteger(Integer.parseInt(str.toString())));
                }
                return n;
            } else if (s.charAt(i) == ',') {
                if (str.length() > 0) {
                    n.add(new NestedInteger(Integer.parseInt(str.toString())));
                }
                str = new StringBuilder();
            } else {
                str.append(s.charAt(i));
            }
            i++;
        }
        if (str.length() > 0) {
            n.setInteger(Integer.parseInt(str.toString()));
        }
        return n;
    }
}

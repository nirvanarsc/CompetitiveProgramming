package leetcode.weekly_contests.weekly_35;

@SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
public class P_591 {

    public boolean isValid(String code) {
        if ("t".equals(code)) {
            return false;
        }
        code = code.replaceAll("<!\\[CDATA\\[.*?]]>", "c");
        String prev = "";
        while (!code.equals(prev)) {
            prev = code;
            code = code.replaceAll("<([A-Z]{1,9})>[^<]*</\\1>", "t");
        }
        return "t".equals(code);
    }
}

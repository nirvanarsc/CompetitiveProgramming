package leetcode.weekly_contests.weekly_100_199.weekly_184;

public class P_1410 {

    public String entityParser(String text) {
        return text.replace("&quot;", "\"")
                   .replace("&apos;", "'")
                   .replace("&gt;", ">")
                   .replace("&lt;", "<")
                   .replace("&frasl;", "/")
                   .replace("&amp;", "&");
    }
}

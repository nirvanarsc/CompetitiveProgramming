package weekly_contests.weekly_184;

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

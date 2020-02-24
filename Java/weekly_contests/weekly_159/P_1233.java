package weekly_contests.weekly_159;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_1233 {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        final List<String> ans = new ArrayList<>(Collections.singletonList(folder[0]));
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(ans.get(ans.size() - 1) + '/')) {
                ans.add(folder[i]);
            }
        }
        return ans;
    }
}

package bubble.greedy;
import java.util.*;
/**
 * ShortestWayToFormString
 */
public class ShortestWayToFormString {
    int solve(String source, String target) {
        int res = 0;
        List<Integer>[] ids = new ArrayList[26];
        Arrays.setAll(ids, ArrayList::new);

        for (int i = 0; i < source.length(); i++) {
            ids[source.charAt(i)-'a'].add(i);
        }

        int idx = -1;
        boolean cannot = false;
        for (int i = 0; i < target.length(); i++) {
            int j = target.charAt(i) - 'a';
            if (ids[j].isEmpty()) {
                cannot = true;
                break;
            }
            int k = 0;
            for (; k < ids[j].size(); k++) {
                if (ids[j].get(k) > idx) {
                    break;
                }
            }
            if (k == ids[j].size()) {
                ++res;
                idx = -1;
                --i;
                continue;
            }
            idx = ids[j].get(k);
            if (idx + 1 == source.length()) {
                ++res;
                idx = -1;
            }

        }
        if (idx != -1) {
            ++res;
        }
        return (cannot|| res==0) ? -1 : res;
    }

    public static void main(String[] args) {
        ShortestWayToFormString instance = new ShortestWayToFormString();
        String source = "abc";
        String target = "abcbc";
        System.out.println(instance.solve(source, target));
    }
    
}
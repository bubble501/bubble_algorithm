package bubble.trie;
import java.util.*;

/**
 * MagicDictSolution
 */
public class MagicDictSolution {

    private Map<String, List<int[]>> map;

    public MagicDictSolution() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dict) {
        map.clear();

        for (String word : dict) {
            char[] w = word.toCharArray();
            for (int i = 0; i < w.length; i++) {
                char temp = w[i];
                w[i] = '_';
                String key = new String(w);
                map.computeIfAbsent(key, 
                    k->new ArrayList<>()).add(new int[] {i, temp});
                w[i] = temp;
            }
        }
    }

    public boolean search(String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            char cur = w[i];
            w[i] = '_';
            String key = new String(w);
            if (map.containsKey(key)){
                for (int[] pair : map.get(key)) {
                    if ((pair[0]==i) && (pair[1]!= cur))  return true;
                }
            }
            w[i] = cur;
        }
        return false;
    }

    public static void main(String[] args) {
        
    }

}
package bubble.unionfind;

import java.util.Map;
import java.util.HashMap;
/**
 * SentenceSimilaritySolution2
 */
public class SentenceSimilaritySolution2 {

    static class DSU {
        Map<String, String> parent = new HashMap<>();
        public DSU(String[][] pairs) {
            for (String[] pair: pairs) {
                parent.putIfAbsent(pair[0], pair[0]);
                parent.putIfAbsent(pair[1], pair[1]);
                union(pair[0], pair[1]);
            }
        }

        public void union(String w1, String w2) {
            parent.put(find(w1), find(w2));
        }

        public String find(String key) {
            String result = key;
            String p = parent.getOrDefault(result, null);
            while ((p!=null)&&(p.equals(result)==false)) {
                result = p;
                p = parent.getOrDefault(result, null);
            }
            if (p.equals(result)) {
                return result;
            }
            parent.put(key, key);
            return key;
        }
    }

    public boolean isSimilar(String[] words1, String[] words2, String[][] pairs ) {
        if(words1.length != words2.length) return false;
        DSU dsu = new DSU(pairs);
        for (int i = 0; i < words1.length; ++i) {
            if (dsu.find(words1[i]).equals(dsu.find(words2[i]))==false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        String[][] pairs = {{"great", "good"}, 
                            {"fine", "good"},
                            {"acting", "drama"},
                            {"skills", "talent"}};
        SentenceSimilaritySolution2 instance = new SentenceSimilaritySolution2();
        if(instance.isSimilar(words1, words2, pairs)) {
            System.out.println("similar");
        } else {
            System.out.println("not similar");
        }
    }
}
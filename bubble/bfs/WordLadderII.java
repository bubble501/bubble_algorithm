package bubble.bfs;
import java.util.*;
/**
 * WordLadderII
 */
public class WordLadderII {
    public List<ArrayList<String>> solve(String startWord, String endWord, List<String> wordList) {
        List<ArrayList<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<String>(wordList);
        if (wordSet.contains(endWord)==false) return res;
        wordSet.remove(startWord);
        wordSet.remove(endWord);

        Map<String, Integer> steps = new HashMap<>();
        steps.put(startWord, 1);
        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(startWord);

        int l = startWord.length();
        int step = 0;
        boolean found = false;

        while (q.isEmpty()== false && found == false) {
            ++step;
            for (int size = q.size(); size > 0; size--) {
                String p = q.poll();
                char[] pChars = p.toCharArray();
                for (int i = 0; i < l; i++) {
                    char ch = pChars[i];
                    for (char j= 'a'; j <= 'z'; j++) {
                        if (j == ch) continue;
                        pChars[i] = j;
                        String w = new String(pChars);
                        if (w.equals(endWord)) {
                            parents.computeIfAbsent(w, k->new ArrayList<>()).add(p);
                            found = true;
                        } else {
                            int orgStep = steps.getOrDefault(w, -1);
                            if (step < orgStep) {
                                parents.computeIfAbsent(w, k->new ArrayList<>()).add(p);
                            } 
                        }
                        if(wordSet.contains(w)==false) continue;
                        wordSet.remove(w);
                        q.offer(w);
                        steps.put(w, steps.get(p)+ 1);
                        parents.computeIfAbsent(w, k->new ArrayList<>()).add(p);
                    }
                    pChars[i]=ch;
                }
            }
        }
        if (found) {
            List<String> curr = new ArrayList<>();
            curr.add(endWord);
        }
        return res;
    }

    // private void getPaths(String word, 
    //                       String beginWord, 
    //                       Map<String, List<String>> parents, 
    //                       List<String> curr, 
    //                       List<ArrayList<String>> ans){
        
    // }
    
}
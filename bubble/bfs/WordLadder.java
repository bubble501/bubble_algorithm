package bubble.bfs;
import java.util.*;
/**
 * WordLadder
 */
public class WordLadder {

    public int solve(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> frontier = new HashSet<String>();
        HashSet<String> explored = new HashSet<String>();
        HashSet<String> wordListHash = new HashSet<String>(wordList);

        int res = 2;

        
        frontier.add(beginWord);
        explored.add(beginWord);
        
        while(!frontier.isEmpty()){
            HashSet<String> temp = new HashSet<String>();
            for(String word: frontier){
                char[] wordchars = word.toCharArray();
                for(int i = 0; i < wordchars.length; i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        char backup = wordchars[i];
                        if(wordchars[i] != c){
                            wordchars[i] = c;
                            String nextword = new String(wordchars);
                            if(wordListHash.contains(nextword)){
                                if(nextword.equals(endWord)) return res;
                                if(!explored.contains(nextword)){
                                    temp.add(nextword);
                                    explored.add(nextword);
                                }
                            }
                        }
                        wordchars[i] = backup;
                    }
                    
                }
            }//for(String word: frontier)
            res ++;
            frontier = temp;
        }//while
        return 0;
    }
}
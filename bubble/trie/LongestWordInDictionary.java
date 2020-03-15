package bubble.trie;
import java.util.*;

/**
 * LongestWordInDictionary
 */
public class LongestWordInDictionary {
    public String solve(String[] words) {
        Set<String> valid = new HashSet<>();
        Arrays.sort(words);
        int maxLength = 0;
        String longestWord = "";
        for (String word : words) {
            if (word.length() < 2 || valid.contains(word.substring(0, word.length()-1))){
                valid.add(word);
                if (word.length()>maxLength) {
                    maxLength = word.length();
                    longestWord = word;
                }
            }
        }
        return longestWord;

    }
    public static void main(String[] args) {
        String[] s = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        LongestWordInDictionary ins = new LongestWordInDictionary();
        System.out.println(ins.solve(s));
    
    }
    
}
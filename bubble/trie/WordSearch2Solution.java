package bubble.trie;
import java.util.*;

/**
 * WordSearch2Solution
 */
public class WordSearch2Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if(cur.next[c-'a']==null) {
                    cur.next[c-'a'] = new TrieNode();
                }
                cur = cur.next[c-'a'];
            }
            cur.word = word;
        }
        return root;
    }

    private static int[][] offsets = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
        if (i < 0 || i >=board.length || j < 0 || j >=board[i].length) {
            return;
        }

        char c = board[i][j];
        if (c =='@' || (root.next[c-'a']==null)){
            return;
        }
        root = root.next[c-'a'];
        if (root.word !=null) {
            result.add(root.word);
            root.word = null;
        }

        board[i][j] = '@';
        for (int[] offset : offsets) {
            dfs(board, i+offset[0], j+offset[1], root, result);            
        }
        board[i][j] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    
}
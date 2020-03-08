package bubble.dfs;

/**
 * SurroundedRegion
 */
public class SurroundedRegion {

    private static final int[][] offsets = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final char X = 'X';
    private static final char O = 'O';
    private static final char S = '*';
    public void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2) return;
        int m = board.length, n = board[0].length;
        int[] rows = {0, m-1};
        int[] cols = {0, n-1};
        for (int i = 0; i < n; i++) {
            for (int row : rows) {
                if (board[row][i] == O) {
                    dfs(board, row, i);
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int col : cols) {
                if (board[i][col] == O) {
                    dfs(board, i, col);
                }
            }
        }

        for (int i=0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == O) {
                    board[i][j] = X;
                } else if(board[i][j] == S) {
                    board[i][j] = O;
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if( i < 0 || i >= board.length || j < 0 || j >= board.length || board[i][j]!=O) {
            return;
        }
        board[i][j] = S;
        for (int[] offset : offsets) {
            dfs(board, i+offset[0], j+offset[1]);
        }
    }

    public static void main(String[] args) {
        SurroundedRegion sr = new SurroundedRegion();
        char[][] board = {{X, X, X, X},
                          {X, O, O, X},
                          {X, X, O, X},
                          {X, O, X, X}};
        sr.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
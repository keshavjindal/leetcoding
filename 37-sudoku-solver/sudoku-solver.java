class Solution {
    public void solveSudoku(char[][] board) {
        // Init sets for row, col, and box
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                boxes[i][j] = new HashSet<>();

        // Fill the sets with initial values
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    rows[i].add(ch);
                    cols[j].add(ch);
                    boxes[i / 3][j / 3].add(ch);
                }
            }
        }

        backtrack(board, 0, 0);
    }

    HashSet<Character>[] rows = new HashSet[9];
    HashSet<Character>[] cols = new HashSet[9];
    HashSet<Character>[][] boxes = new HashSet[3][3];
    boolean solved = false;

    public void backtrack(char[][] board, int i, int j) {
        if (i == 9) {
            solved = true;
            return;
        }

        int nextI = (j == 8) ? i + 1 : i;
        int nextJ = (j + 1) % 9;

        if (board[i][j] != '.') {
            backtrack(board, nextI, nextJ);
        } else {
            for (char c = '1'; c <= '9'; c++) {
                if (!rows[i].contains(c) && !cols[j].contains(c) && !boxes[i / 3][j / 3].contains(c)) {
                    board[i][j] = c;
                    rows[i].add(c);
                    cols[j].add(c);
                    boxes[i / 3][j / 3].add(c);

                    backtrack(board, nextI, nextJ);

                    if (solved) return; // Early return if done

                    // backtrack
                    board[i][j] = '.';
                    rows[i].remove(c);
                    cols[j].remove(c);
                    boxes[i / 3][j / 3].remove(c);
                }
            }
        }
    }
}

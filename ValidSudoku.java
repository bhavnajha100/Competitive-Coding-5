// Time Complexity: O(1) --- because it is 9*9 grid
// Space Complexity: O(1)

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;

        // for row
        for (int r = 0; r < 9; r++) {
            boolean[] b = new boolean[9];
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.')
                    continue;
                else {
                    if (!b[(int) board[r][c] - '1'])
                        b[(int) board[r][c] - '1'] = true;
                    else
                        return false;
                }
            }
        }

        // for column
        for (int c = 0; c < 9; c++) {
            boolean[] b = new boolean[9];
            for (int r = 0; r < 9; r++) {
                if (board[r][c] == '.')
                    continue;
                else {
                    if (!b[(int) board[r][c] - '1'])
                        b[(int) board[r][c] - '1'] = true;
                    else
                        return false;
                }
            }
        }

        // for 3 * 3 block
        for (int block = 0; block < 9; block++) {
            boolean[] b = new boolean[9];

            for (int r = block / 3 * 3; r < block / 3 * 3 + 3; r++) {
                for (int c = block % 3 * 3; c < block % 3 * 3 + 3; c++) {
                    if (board[r][c] == '.')
                        continue;
                    else {
                        if (!b[(int) board[r][c] - '1'])
                            b[(int) board[r][c] - '1'] = true;
                        else
                            return false;
                    }
                }
            }
        }

        return true;
    }
}
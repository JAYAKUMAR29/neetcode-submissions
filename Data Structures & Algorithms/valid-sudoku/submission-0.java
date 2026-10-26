
class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                char num = board[i][j];

                // Check row and column
                for (int k = 0; k < 9; k++) {
                    if (k != j && board[i][k] == num) {
                        return false;
                    }

                    if (k != i && board[k][j] == num) {
                        return false;
                    }
                }

                // Check 3x3 box
                int startRow = (i / 3) * 3;
                int startCol = (j / 3) * 3;

                for (int r = startRow; r < startRow + 3; r++) {
                    for (int c = startCol; c < startCol + 3; c++) {

                        if ((r != i || c != j)
                                && board[r][c] == num) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

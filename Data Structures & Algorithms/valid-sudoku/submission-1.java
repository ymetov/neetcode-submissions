class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isSquareValid(
                    board,
                    i * 3,
                    j * 3,
                    rowMap,
                    columnMap
                )) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSquareValid(char[][] board, int row, int column, Map<Integer, Set<Character>> rowMap, Map<Integer, Set<Character>> columnMap) {
        Set<Character> set = new HashSet<>();
        for (int i = row; i < row+3; i++){
            for (int j = column; j < column+3; j++) {
                if (set.contains(board[i][j])) return false;
                else if (board[i][j] >= '0' && board[i][j] <= '9') set.add(board[i][j]);

                rowMap.computeIfAbsent(i, k -> new HashSet<>());
                if (rowMap.get(i).contains(board[i][j])) return false;
                else if (board[i][j] >= '0' && board[i][j] <= '9') rowMap.get(i).add(board[i][j]);

                columnMap.computeIfAbsent(j, k -> new HashSet<>());
                if (columnMap.get(j).contains(board[i][j])) return false;
                else if (board[i][j] >= '0' && board[i][j] <= '9') columnMap.get(j).add(board[i][j]);
            }
        }
        return true;
    }
}

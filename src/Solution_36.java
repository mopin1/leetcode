import java.util.HashSet;

class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer> [] columns = new HashSet[9];
        HashSet<Integer> [] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int box_index = (i / 3 ) * 3 + j / 3;

                    if(rows[i].contains((int) num) || columns[j].contains((int) num) || boxes[box_index].contains((int) num))
                        return false;
                    else {
                        rows[i].add((int) num);
                        columns[j].add((int) num);
                        boxes[box_index].add((int) num);
                    }
                }
            }
        }
        return true;
    }
}

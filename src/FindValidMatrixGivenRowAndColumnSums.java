public class FindValidMatrixGivenRowAndColumnSums {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];

        int curr_row = 0;
        int curr_col = 0;

        while (curr_row < rowSum.length && curr_col < colSum.length) {
            if (rowSum[curr_row] <= colSum[curr_col]) {
                result[curr_row][curr_col] = rowSum[curr_row];
                colSum[curr_col] -= rowSum[curr_row];
                curr_row++;
            } else if (colSum[curr_col] < rowSum[curr_row]){
                result[curr_row][curr_col] = colSum[curr_col];
                rowSum[curr_row] -= colSum[curr_col];
                curr_col++;
            }
        }

        return result;
    }

}

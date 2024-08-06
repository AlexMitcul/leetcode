public class MinimumNumberofFlipstoMakeBinaryGridPalindromicI {
    public int minFlips(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;

        int rows = 0;
        for (int row = 0; row < height; row++) {
            int left = 0;
            int right = width - 1;
            while (left < right) {
                if (grid[row][left] != grid[row][right]) rows++;
                left++;
                right--;
            }
        }

        int cols = 0;
        for (int col = 0; col < width; col++) {
            int top = 0;
            int bottom = height - 1;
            while (top < bottom) {
                if (grid[top][col] != grid[bottom][col]) cols++;
                top++;
                bottom--;
            }
        }

        return Math.min(rows, cols);
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,0,0},{0,0,0},{0,0,1}};
//        int[][] matrix = new int[][]{{0,0}};
        int[][] matrix = new int[][]{{0},{0},{1},{0}};
        var solver = new MinimumNumberofFlipstoMakeBinaryGridPalindromicI();
        int result = solver.minFlips(matrix);
        System.out.println(result);
    }
}

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # we can use the flags to check if row or col contain zero and set entire row/col to 0's 
        # it is a space O(1) solution
        rows = set()
        cols = set()
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == 0:
                    rows.add(row)
                    cols.add(col)
        
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if row in rows or col in cols:
                    matrix[row][col] = 0
        
        

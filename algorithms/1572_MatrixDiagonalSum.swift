class Solution {
    func diagonalSum(_ mat: [[Int]]) -> Int {
        var sum = 0
        let size = mat.count
        for i in 0..<mat.count/2 {
            sum += mat[i][i] + mat[size-i-1][size-i-1] + mat[i][size-i-1] + mat[size-i-1][i]
        }

        if size % 2 != 0 {
            //let i = mat.count / 2
            sum += mat[mat.count/2][mat.count/2]
        }
        
        return sum 
    }
}
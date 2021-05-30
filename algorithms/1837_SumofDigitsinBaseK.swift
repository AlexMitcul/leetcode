class Solution {
    func sumBase(_ n: Int, _ k: Int) -> Int {
        var sum = 0
        var number = n
        while number > 0 {
            sum += number % k
            number /= k
        }
        
        return sum
    }
}
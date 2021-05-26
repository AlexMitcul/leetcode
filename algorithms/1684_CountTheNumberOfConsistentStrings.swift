/*
https://leetcode.com/problems/count-the-number-of-consistent-strings/
*/

class Solution {
    func countConsistentStrings(_ allowed: String, _ words: [String]) -> Int {
        var count = 0
        var allow = true
        for word in words {
            allow = true
            for ch in word {
                if !allowed.contains(ch) {
                    allow = false
                    break
                }
            }
            if allow {
                count += 1
            }
        }
        
        return count
    }
}

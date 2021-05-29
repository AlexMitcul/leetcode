// One-line solution

class Solution {
    func truncateSentence(_ s: String, _ k: Int) -> String {
        return s.split(separator: " ")[..<k].joined(separator: " ")
    }
}


/*
class Solution {
    func truncateSentence(_ s: String, _ k: Int) -> String {
        var x = k;
        for (i, ch) in s.enumerated() {
            if x == 0 {
                let index = s.index(s.startIndex, offsetBy: i-1)
                let substring = s[..<index]
                return String(substring)
            }
            if ch == " " {
                x -= 1;
            }
        }
        return s
    }
}
*/

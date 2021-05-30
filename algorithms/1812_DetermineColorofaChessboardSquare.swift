class Solution {
    func squareIsWhite(_ coordinates: String) -> Bool {
        
        let first = (Int(coordinates.first!.asciiValue ?? 97) - 97) % 2
        let second = (Int(String(coordinates.last!)) ?? 1) % 2

        return first == second
    }
}
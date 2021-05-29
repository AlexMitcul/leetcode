class Solution {
    func largestAltitude(_ gain: [Int]) -> Int {
        
        let newGain = gain.reduce(into: []) { $0.append(($0.last ?? 0) + $1) }
        return max(0, newGain.max()!)

    }
}

class Solution {
    func sortSentence(_ s: String) -> String {
        var result = ""
        var words = s.components(separatedBy: " ")

        words = words.sorted(by: { $0.last! < $1.last! })
        for word in words {
            let range = word.startIndex..<word.index(before: word.endIndex)
            
            result = result + String(word[range]) + " " 
        }
        result.removeLast()
        
        return result
    }
}
import Foundation

func solution(_ expression:String) -> Int64 {
    var operators = expression.split{$0.isNumber}
    var numbers = expression.split{!$0.isNumber}
    var opTypes = Array(Set(operators))
    var opSequences = [String]()

    var vst = Array(repeating: false, count: opTypes.count)
    func dfs(_ opStr: String) {
        if opStr.count == opTypes.count {
            opSequences.append(opStr)
        }
        
        for i in 0..<opTypes.count {
            guard !vst[i] else { continue }
            vst[i] = true
            dfs(opStr + opTypes[i])
            vst[i] = false
        }
    }
    
    var separted = [String]()
    for i in 0..<numbers.count - 1 {
        separted.append(String(numbers[i]))
        separted.append(String(operators[i]))
    }
    separted.append(String(numbers.last!))
    
    var max = 0
    for opSequence in opSequences {
        for char in opSequence {
            for i in 0..<separted.count {
                if String(char) == separted[i] {
                    switch char {
                    case "*":
                        opSequence[i]
                    case "+":
                        
                    case "-":
                        
                    default:
                        break
                    }
                }
            }
        }
    }
    
    return 0
}

print(solution("100-200*300-500+20"))

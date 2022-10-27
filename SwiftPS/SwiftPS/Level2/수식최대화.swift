//
//  수식최대화.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/24.
//

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




//
//  올바른괄호변한.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/17.
//

import Foundation

func solution(_ p:String) -> String {
    func isValid(_ p: [Character]) -> Bool {
        var stack = [Character]()
        for char in p {
            if char == "(" {
                stack.append(char)
            } else if char == ")" {
                if stack.popLast() != "(" {
                    return false
                }
            }
        }
        return true
    }
    
    func recursive(_ w: [Character]) -> [Character] {
        guard w.count != 0 else { return [] }
        
        var wArr: [Character] = w.map{$0}
        // u, v 분리
        var open = 0
        var close = 0
        var splitIndex = 0
        for i in 0..<wArr.count {
            if wArr[i] == "(" {
                open += 1
            } else {
                close += 1
            }
            if open == close {
                splitIndex = i
                break
            }
        }
        
        var u = Array(wArr[0...splitIndex])
        var v = Array(wArr[splitIndex + 1..<wArr.count])
        
        if isValid(u) {
            return u + recursive(v)
        }
        else {
            var temp: [Character] = ["("]
            temp += recursive(v)
            temp.append(")")
            u.removeFirst()
            u.removeLast()
            let newU: [Character] = u.map{
                if $0 == "(" {return ")"}
                else {return "("}
            }
            temp += newU
            
            return temp
        }
    }
    return String(recursive(Array(p)))
}

print(solution(")("))


//
//  괄호회전하기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/03.
//

import Foundation

func solution(_ s:String) -> Int {
    if s.count % 2 == 1 {return 0}
    
    var result = 0
    var string = s
    
    for _ in 0..<s.count {
        if check(string) { result += 1}
        string.append(string.removeFirst())
    }
    
    return result
}

func check(_ s: String) -> Bool {
    var isValid = true
    var stack = [Character]()
    let match: [Character : Character] = ["]":"[", ")":"(", "}":"{"]
    for char in s {
        switch char {
            case "[", "(", "{":
            stack.append(char)
            default:
            if stack.popLast() != match[char] {
                isValid = false
                break
            }
        }
    }
    return stack.count == 0 && isValid
}

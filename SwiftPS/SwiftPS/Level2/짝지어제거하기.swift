//
//  짝지어제거하기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/01.
//

import Foundation

func solution(_ s:String) -> Int{
    if s.count % 2 == 1 {return 0}
    var stack: [Character] = []
    
    for char in s {
        if stack.last == char {
            stack.popLast()
        } else {
            stack.append(char)
        }
    }
    
    return stack.isEmpty ? 1 : 0
}

print(solution("baabaa"))

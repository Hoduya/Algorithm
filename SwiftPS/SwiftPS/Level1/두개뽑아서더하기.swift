//
//  두개뽑아서더하기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/29.
//

import Foundation

func solution(_ numbers:[Int]) -> [Int] {
    var numSet = Set<Int>()

    for i in 0..<(numbers.count - 1) {
        for j in (i + 1)..<numbers.count {
            numSet.insert(numbers[i] + numbers[j])
        }
    }
    
    return Array(numSet).sorted()
}

print(solution([2,1,3,4,1]))

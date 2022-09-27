//
//  없는숫자더하기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//

import Foundation

func solution(_ numbers:[Int]) -> Int {
    return Array(0...9).filter{ !numbers.contains($0) }.reduce(0, +)
}

print(solution([1,2,3,4,5,6,7]))


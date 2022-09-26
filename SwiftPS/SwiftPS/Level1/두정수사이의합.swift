//
//  두정수사이의합.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//

import Foundation

func solution(_ a:Int, _ b:Int) -> Int64 {
    return Int64((abs(a - b) + 1) * (a + b) / 2)
}

print(solution(3, 4))

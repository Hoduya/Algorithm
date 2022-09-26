//
//  짝수와홀수.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//

import Foundation

func solution(_ num:Int) -> String {
    return num % 2 == 0 ? "Even" : "Odd"
}

print(solution(2))

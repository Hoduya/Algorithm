//
//  수박수박수.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//

import Foundation

func solution(_ n: Int) -> String {
    var answer = ""
    for i in 0..<n {
        answer += i % 2 == 0 ? "수" : "박"
    }
    return answer
}

print(solution(4))

//
//  n^2배열자르기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/03.
//

import Foundation

func solution(_ n:Int, _ left:Int64, _ right:Int64) -> [Int] {
    var answer = [Int]()
    for i in Int(left)...Int(right) {
        let row = i / n + 1
        let col = i % n + 1
        answer.append(row > col ? row : col)
    }
    return answer
}

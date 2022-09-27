//
//  약수의개수와덧셈.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/27.
//

import Foundation

func solution(_ left:Int, _ right:Int) -> Int {
    return (left...right).map{i in (1...i).filter{i % $0 == 0}.count % 2 == 0 ? i : -i}.reduce(0, +)
}

func solution2(_ left:Int, _ right:Int) -> Int {
    var result = 0
    for i in (left...right) {
        var count = 0
        for j in (1...i) {
            if i % j == 0 {
                count += 1
            }
        }
        result += count % 2 == 0 ? i : -i
    }
    return result
}

print(solution2(13, 17))


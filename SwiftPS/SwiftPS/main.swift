//
//  숫자게임.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/12.
//

import Foundation

func solution(_ a:[Int], _ b:[Int]) -> Int {
    let sortA = a.sorted(by: >)
    let sortB = b.sorted(by: >)
    
    print(sortA)
    print(sortB)
    var score = 0
    var bIdx = 0
    for aIdx in 0..<sortA.count {
        if sortB[bIdx] > sortA[aIdx] {
            score += 1
            bIdx += 1
        }
    }
    return score
}

print(solution([5,1,3,7], [2,2,6,8]))

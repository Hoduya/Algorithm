//
//  로또최고순위와최저순위.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/30.
//

import Foundation

func solution(_ lottos:[Int], _ win_nums:[Int]) -> [Int] {
    var answer: [Int] = []
    var winCount = 0
    var zeroCount = 0
    
    lottos.forEach {
        if win_nums.contains($0) {winCount += 1}
        if $0 == 0 {zeroCount += 1}
    }
    
    let best = winCount + zeroCount
    let worst = winCount
    
    answer.append(best == 0 ? 6 : 7 - best)
    answer.append(worst == 0 ? 6 : 7 - worst)
        
    return answer
}

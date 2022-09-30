//
//  실패율.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/29.
//

import Foundation

func solution(_ N:Int, _ stages:[Int]) -> [Int] {
    // 스테이지의 개수 N
    // stages 현재 도전중인 스테이지 번호 (N + 1)은 마지막까지 완료한 사용자

    // 스테이지 별 도달했으나 클리어 못한 수
    var numStage = Array(repeating: 0, count: N + 2)
    stages.forEach{numStage[$0] += 1}
    
    // 스테이지 별 도달한 플레이어 수
    var clearStage: [Int] = []
    var sum = 0
    for num in numStage.reversed(){
        sum += num
        clearStage.append(sum)
    }
    clearStage.reverse()
    
    // 스테이지 별 실패율
    var failures: [Int : Double] = [:]
    for i in 1...N {
        guard clearStage[i] > 0 else {
            failures[i] = 0
            continue
        }
        failures[i] = Double(numStage[i]) / Double(clearStage[i])
    }
    
    return failures.sorted {
        if $0.value == $1.value { return $0.key < $1.key}
        return $0.value > $1.value
    }.map{Int($0.key)}
}

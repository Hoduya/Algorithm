//
//  위장.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/04.
//

// DFS 조합 -> 시간초과
// 아무것도 입지 않은 경우 고려해서 (n1 + 1) * (n1 + 2)... - 1
import Foundation

func solution(_ clothes:[[String]]) -> Int {
    var mapCounts = [String : Int]()
    clothes.forEach { mapCounts[$0[1]] = (mapCounts[$0[1]] ?? 0) + 1 }
    let result = mapCounts.reduce(1) {$0 * ($1.value + 1)} - 1
    
    return result
}

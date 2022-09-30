//
//  체육복.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/30.
//

import Foundation

func solution(_ n:Int, _ lost:[Int], _ reserve:[Int]) -> Int {
    var isReserve = Array(repeating: false, count: n + 2)
    reserve.forEach{ isReserve[$0] = true }
    let lost = lost.filter{
        if isReserve[$0] {
            isReserve[$0] = false
            return false
        }
        return true
    }
    
    var result = n - lost.count
    
    print(lost)
    
    for i in lost.sorted() {
        if isReserve[i - 1] { isReserve[i - 1] = false }
        else if isReserve[i + 1] { isReserve[i + 1] = false }
        else { continue }
        result += 1
    }
    return result
}


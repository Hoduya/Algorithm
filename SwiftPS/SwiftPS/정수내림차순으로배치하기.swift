//
//  File.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/22.
//

import Foundation

func solution(_ n:Int64) -> Int64 {
    var num = n
    var numArr: [Int64] = []
    
    while(num > 0) {
        numArr.append(num % 10)
        num /= 10
    }
    
    numArr.sort(by:>)
    
    var result: Int64 = 0
    for i in 0..<numArr.count {
        result += numArr[i]
        result *= 10
    }
        
    return result / 10
}

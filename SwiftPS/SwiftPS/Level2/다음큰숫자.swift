//
//  다음큰숫자.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/01.
//

import Foundation

func solution(_ n:Int) -> Int
{
    var num = n
    let ones = String(num, radix: 2).reduce(0){ $0 + ($1 == "1" ? 1 : 0) }
    var oneCount = 0
    
    while(ones != oneCount) {
        num += 1
        oneCount = String(num, radix: 2).reduce(0){ $0 + ($1 == "1" ? 1 : 0) }
    }
    
    return num
}

//
//  예상대진표.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/01.
//

import Foundation

func solution(_ n:Int, _ a:Int, _ b:Int) -> Int{
    var round = 0
    var A = a - 1
    var B = b - 1
    
    while(A != B) {
        A /= 2
        B /= 2
        round += 1
    }
    
    return round
}

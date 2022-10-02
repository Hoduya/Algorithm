//
//  점프와순간이동.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/02.
//

import Foundation

func solution(_ n:Int) -> Int {
    guard n > 1 else { return 1 }
    // N 이 홀수일 경우 [n - 1] + 1
    // n 이 짝수일 경우 [n / 2]
    
    var n = n
    var jump = 1
    while n != 1 {
        jump += n % 2
        n /= 2
    }
    
    return jump
}

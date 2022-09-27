//
//  최대공약수와 최소공배수.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/27.
//

import Foundation

func solution(_ n:Int, _ m:Int) -> [Int] {
    let gcd = GCD(n, m)
    return [gcd, n * m / gcd]
}

func GCD(_ a: Int, _ b: Int) -> Int{
    if(b == 0) {
        return a
    }
    return GCD(b, a % b)
}

print(solution(3, 12))

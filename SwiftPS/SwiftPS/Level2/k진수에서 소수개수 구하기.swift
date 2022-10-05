//
//  k진수에서 소수개수 구하기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/04.
//

import Foundation

func solution(_ n:Int, _ k:Int) -> Int {
    var arr = String(n, radix: k).split(separator: "0").map{Int($0)!}
    arr = arr.filter{$0 != 1}
    return arr.reduce(0){ $0 + (isPrime($1) ? 1 : 0)}
}

func isPrime(_ n: Int) -> Bool{
    for num in 2...Int(sqrt(Double(n))) + 1 {
        if n % num == 0 {
            return false
            break
        }
    }
    return true
}


solution(1000000, 10)


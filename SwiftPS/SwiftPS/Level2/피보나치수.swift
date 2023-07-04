//
//  피보나치수.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/01.
//

var dp = Array<Int>()

func solution(_ n:Int) -> Int {
    dp = Array(repeating: -1, count: n + 1)
    return fibo(n)
}

func fibo(_ n: Int) -> Int{
    if(n == 0) { return 0 }
    if(n == 1) { return 1 }
    if(dp[n] != -1) {
        return dp[n]
    }
    
    dp[n] = (fibo(n - 2) + fibo(n - 1)) % 1234567
    return dp[n]
}

solution(1000)

//
//  땅따먹기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/07.
//

import Foundation

func solution(_ land:[[Int]]) -> Int{
    var dp = Array(repeating: Array(repeating: 0, count: 4), count: land.count)
    dp[0][0...3] = land[0][0...3]
    
    for i in 1..<land.count {
        for j in 0..<4 {
            var maxScore = 0
            for k in 0..<4 {
                guard j != k else { continue }
                maxScore = max(maxScore, dp[i - 1][k])
            }
            dp[i][j] = land[i][j] + maxScore
        }
    }
    
    return dp[land.count - 1].max()!
}


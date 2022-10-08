//
//  피로도.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/07.
//

import Foundation

var maxCount = 0
var vst = [Bool]()
func solution(_ k:Int, _ dungeons:[[Int]]) -> Int {
    vst = Array(repeating: false, count: dungeons.count)
    
    dfs(0, k, dungeons)
    
    return maxCount
}

func dfs(_ count: Int, _ k: Int, _ dungeons:[[Int]]) {
    if maxCount < count {
        maxCount = count
    }
    
    for i in 0..<dungeons.count {
        if k >= dungeons[i][0] && !vst[i] {
            vst[i] = true
            dfs(count + 1, k - dungeons[i][1], dungeons)
            vst[i] = false
        }
    }
}

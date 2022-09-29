//
//  최소직사각형.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/28.
//

import Foundation

func solution(_ sizes:[[Int]]) -> Int {
    // 1. 어차피 한 변의 길이는 max를 포함해야함. 각 명함의 가로 세로 중 max 찾기
    // 2. 명함을 긴 변이 가로로 오도록 돌린다.
    //      지갑의 가로는 max 이므로 세로중 최대값을 찾으면 됨
    
    var sizes = sizes
    var maxWidth = 0
    var maxHeight = 0
    
    for i in 0..<sizes.count {
        if sizes[i][0] < sizes[i][1] {
            sizes[i].swapAt(0, 1)
        }

        maxWidth = max(maxWidth, sizes[i][0])
        maxHeight = max(maxHeight, sizes[i][1])
    }
    
    return maxWidth * maxHeight
}

func solution2(_ sizes:[[Int]]) -> Int {
    var maxNum = 0
    var minNum = 0

    for size in sizes {
        maxNum = max(maxNum, size.max()!)
        minNum = max(minNum, size.min()!)
    }
    return maxNum * minNum
}


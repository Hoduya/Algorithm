//
//  행렬곱셈.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/02.
//

import Foundation

func solution(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
    var arr = [[Int]]()
    
    for i in 0..<arr1.count {
        arr.append([])
        for j in 0..<arr2.count {
            var sum = 0
            for k in 0..<arr2.count {
                sum += arr1[i][k] * arr2[k][j]
            }
            arr[i].append(sum)
        }
    }
    return arr
}

print(solution([[1, 4], [3, 2], [4, 1]]    , [[3, 3], [3, 3]] ))

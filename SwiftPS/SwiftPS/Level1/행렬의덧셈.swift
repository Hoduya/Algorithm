//
//  행렬의덧셈.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/27.
//

import Foundation

func solution(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
    var result = [[Int]]()
    for i in 0..<arr1.count {
        result.append([])
        for j in 0..<arr1[i].count {
            result[i].append(arr1[i][j] + arr2[i][j])
        }
    }
    return result
}

func solution2(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
    var result = Array(repeating: Array(repeating: 0, count: arr1[0].count), count: arr1.count)
    for i in 0..<arr1.count {
        for j in 0..<arr1[i].count {
            result[i][j] = arr1[i][j] + arr2[i][j]
        }
    }
    return result
}


func solution3(_ arr1:[[Int]], _ arr2:[[Int]]){
    print(zip(arr1, arr2).map{zip($0, $1).map{$0 + $1}})
}

print(solution([[1,2],[2,3]],[[3,4],[5,6]]))
print(solution2([[1,2],[2,3]],[[3,4],[5,6]]))


//
//  쿼드압축.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/10.
//

import Foundation

var result = [0, 0]
func solution(_ arr:[[Int]]) -> [Int] {
    compress(arr, 0, 0, arr.count)
    return result
}

func compress(_ arr: [[Int]], _ row: Int, _ col: Int, _ n: Int) {
    if isAllSame(arr, row, col, n) {
        result[arr[row][col]] += 1
    }
    else {
        compress(arr, row, col, n/2)
        compress(arr, row, col + n/2, n/2)
        compress(arr, row + n/2, col + n/2, n/2)
        compress(arr, row + n/2, col, n/2)
    }
}

func isAllSame(_ arr: [[Int]], _ row: Int, _ col: Int, _ n: Int) -> Bool {
    let symbol = arr[row][col]
    for i in row..<row + n {
        for j in col..<col + n {
            if symbol != arr[i][j] { return false }
        }
    }
    return true
}

print(solution([[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]))

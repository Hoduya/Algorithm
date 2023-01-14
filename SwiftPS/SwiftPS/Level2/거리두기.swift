//
//  거리두기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/28.
//

import Foundation

func solution(_ places:[[String]]) -> [Int] {
    var result = [Int]()
    
    for place in places {
        var arr = place.map{Array($0)}
        
        var isSafe = true
        
        for i in 0..<arr.count {
            for j in 0..<arr[i].count {
                if arr[i][j] == "P" {
                    if !checkAroundSafe(arr: arr, x: j, y: i) {
                        isSafe = false
                    }
                }
                if !isSafe { break }
            }
        }
        result.append(isSafe ? 1 : 0)
    }
    return result
}

func checkAroundSafe(arr: [[String.Element]], x: Int, y: Int) -> Bool {
    let dx = [0, 0, -1, 1, 0, 0, -2, 2, -1, 1, -1, 1]
    let dy = [-1, 1, 0, 0, -2, 2, 0, 0, -1, -1, 1, 1]
    
    for i in 0..<12 {
        let tx = x + dx[i]
        let ty = y + dy[i]
        
        guard isInMap(tx, ty) else { continue }

        switch i {
        case 0...3:
            print(arr)
            if arr[ty][tx] == "P" { return false }
        case 4...7:
            if arr[ty][tx] == "P" {
                if arr[(y + ty) / 2][(x + tx) / 2] != "X" { return false }
            }
        case 8...11:
            if arr[ty][tx] == "P" {
                if arr[ty][x] != "X" || arr[y][tx] != "X" { return false }
            }
        default: break
        }
    }
    return true
}

func isInMap(_ x: Int, _ y: Int) -> Bool {
    return x >= 0 && y >= 0 && x < 5 && y < 5
}


print(solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]))

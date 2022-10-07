//
//  프렌즈4블록.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/07.
//

struct Point: Hashable {
    let x: Int
    let y: Int
}

func solution(_ m:Int, _ n:Int, _ board:[String]) -> Int {
    var samePoints = Set<Point>()
    var board = board.map{Array($0)}
    var score = 0
    let dx = [0, 1, 1, 0]
    let dy = [0, 0, 1, 1]
    var isBoardChanged = true
    
    while isBoardChanged {
        isBoardChanged = false
        for i in 0..<m - 1 {
            for j in 0..<n - 1 {
                let symbol = board[i][j]
                
                guard symbol != "-" else {continue}
                
                var sameFlag = true
                for k in 1..<4 {
                    let tx = j + dx[k]
                    let ty = i + dy[k]
                    if symbol != board[ty][tx] {
                        sameFlag = false
                        break
                    }
                }
                if sameFlag {
                    for k in 0..<4 {
                        samePoints.insert(Point(x: j + dx[k], y: i + dy[k]))
                    }
                    isBoardChanged = true
                }
            }
        }
        
        if isBoardChanged {
            samePoints.forEach{board[$0.y][$0.x] = "-"}
            score += samePoints.count
        } else {
            break
        }
        
        for i in (1..<m).reversed() {
            for j in 0..<n {
                if board[i][j] == "-" {
                    var upperRow = i - 1
                    while upperRow >= 0 {
                        if board[upperRow][j] != "-" {
                            board[i][j] = board[upperRow][j]
                            board[upperRow][j] = "-"
                            break
                        }
                        upperRow -= 1
                    }
                }
            }
        }
        samePoints.removeAll()
    }
    return score
}

print(solution(4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"]))

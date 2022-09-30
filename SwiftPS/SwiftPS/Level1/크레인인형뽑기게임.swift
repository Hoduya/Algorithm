//
//  크레인인형뽑기게임.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/30.
//

import Foundation

func solution(_ board:[[Int]], _ moves:[Int]) -> Int {
    var answer = 0
    // 2차원 배열의 열 개수 만큼 스택 만들기
    let N = board.count
    var stacks = Array(repeating: [Int](), count: N)
    
    for i in 0..<N {
        for j in 0..<N {
            guard board[i][j] != 0 else { continue }
            stacks[j].append(board[i][j])
        }
    }
    stacks = stacks.map{ $0.reversed() }
    
    // 바구니 스택 만들기
    var stack = Array<Int>()
    
    // moves 배열 순회
    for move in moves {
        if let removed = stacks[move - 1].popLast() {
            if stack.last == removed{
                stack.popLast()
                answer += 2
            } else {
                stack.append(removed)
            }
        }
    }
    return answer
}

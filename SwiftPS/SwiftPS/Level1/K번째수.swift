//
//  K번째수.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/28.
//

import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    var answer: [Int] = []
    
    commands.forEach { command in
        let c = command.map{$0 - 1}
        let result = array[c[0]...c[1]].sorted(by: <)[c[2]]
        answer.append(result)
    }
    
    return answer
}

func solution2(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    return commands.map{ array[$0[0]-1...$0[1]-1].sorted()[$0[2]-1] }
}

print(solution2([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]))


//
//  튜플.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/03.
//

import Foundation

func solution(_ s:String) -> [Int] {
    var str = s
    str.removeLast(2)
    str.removeFirst(2)
    
    var answer = [Int]()
    var arr = str.components(separatedBy: "},{")
    arr.sort{ $0.count < $1.count }

    var set = Set<Int>()
    for string in arr {
        let nums = string.split(separator: ",")
        for string in nums {
            if set.insert(Int(string)!).inserted {
                answer.append(Int(string)!)
            }
        }
    }
    return answer
}

print(solution("{{20,111},{111}}"))


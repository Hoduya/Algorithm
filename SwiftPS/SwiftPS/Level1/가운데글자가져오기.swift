//
//  가운데글자가져오기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//

import Foundation

func solution(_ s: String) -> String {
    var answer = ""
    var arr = s.map{$0}
    if(arr.count % 2 == 0) {
        answer.append(arr[arr.count / 2-1])
        answer.append(arr[arr.count / 2])
    } else {
        answer.append(arr[arr.count / 2])
    }
    return answer
}

func solution2(_ s: String) -> String {
    return String(Array(s)[(s.count - 1) / 2...(s.count) / 2])
}

print(solution2("asdf"))

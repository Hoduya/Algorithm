//
//  비밀지도.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/28.
//

import Foundation

func solution(_ n:Int, _ arr1:[Int], _ arr2:[Int]) -> [String] {
    var answer: [String] = []
    
    for (x, y) in zip(arr1, arr2) {
        let binaryString = (String(repeating: "0", count: n) + (String(x | y, radix: 2))).suffix(n)
        var codeString: String = ""
        for char in binaryString {
            codeString += char == "1" ? "#" : " "
        }
        answer.append(codeString)
    }
    return answer
}

print(("00000" + (String(1, radix: 2))).suffix(5))






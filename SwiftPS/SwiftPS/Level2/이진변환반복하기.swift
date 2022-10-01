//
//  이진변환반복하기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/30.
//

import Foundation

func solution(_ s:String) -> [Int] {
    var count = 0
    var zeros = 0

    var numString = s
    
    while(numString != "1") {
        count += 1
        
        let before = numString.count
        // 0 제거
        numString = numString.replacingOccurrences(of:"0", with:"")
        
        let after = numString.count
        
        // 0 카운트
        zeros += before - after

        // 이진 변환
        numString = String(after, radix:2)
        print(numString)
    }

    return [count, zeros]
}

print(solution("11001101"))

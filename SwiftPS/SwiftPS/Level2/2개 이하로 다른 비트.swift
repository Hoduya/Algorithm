//
//  2개 이하로 다른 비트.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/07.
//

import Foundation

func solution(_ numbers:[Int64]) -> [Int64] {
    // 짝수일 경우 끝자리 1만 추가 되기 때문에 +1이 제일 작은 수
    var answer = [Int64]()
    
    numbers.forEach{ number in
        if number % 2 == 0 {
            answer.append(number + 1)
        }
        else {
            var temp = number
            var zeroIndex = 0
            while temp % 2 != 0 {
                temp /= 2
                zeroIndex += 1
            }
            answer.append(number + Int64(pow(2.0, Double(zeroIndex - 1))))
        }
    }
    return answer
}


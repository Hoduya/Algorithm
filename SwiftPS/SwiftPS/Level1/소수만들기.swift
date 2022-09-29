//
//  소수만들기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/29.
//

import Foundation

var isPrime: [Bool] = []
var result: Int = 0
var numbers: [Int] = []

func solution(_ nums:[Int]) -> Int {
    numbers = nums
    
    makePrimes(nums.max()! * 3)

    combination(0, 0, 0)
    
    return result
}

func makePrimes(_ count: Int) {
    isPrime = Array(repeating: true, count: count + 1)
    let end = Int(sqrt(Double(count)))
    for i in 2...end{
        if isPrime[i] {
            for j in stride(from: i + i, through: count, by: i) {
                isPrime[j] = false
            }
        }
    }
}

func combination(_ start: Int, _ depth: Int, _ sum: Int) {
    if(depth == 3) {
        result += isPrime[sum] ? 1 : 0
        return
    }
    
    for i in start..<numbers.count {
        combination(i + 1, depth + 1, sum + numbers[i])
    }
}

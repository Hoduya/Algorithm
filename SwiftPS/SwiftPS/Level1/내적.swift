//
//  내적.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//
import Foundation

func solution(_ a:[Int], _ b:[Int]) -> Int {
    var sum = 0
    for i in 0..<a.count {
        sum += a[i] * b[i]
    }
    return sum
}

func solution2(_ a:[Int], _ b:[Int]) -> Int {
    return zip(a, b).map{ $0 * $1 }.reduce(0){ $0 + $1 }
}

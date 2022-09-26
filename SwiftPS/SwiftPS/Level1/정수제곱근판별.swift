//
//  정수제곱근판별.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//
import Foundation

func solution(_ n:Int64) -> Int64 {
    var i: Int64 = 1
    while i * i < n {
        i += 1
    }
    return i * i == n ? (i + 1) * (i + 1) : -1
}

func solution2(_ n:Int64) -> Int64 {
    let rt = Int64(sqrt(Double(n)))
    return rt * rt == n ? (rt + 1) * (rt + 1) : -1
}

//
//  평균구하기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//

import Foundation

func solution(_ arr:[Int]) -> Double {
    let sum = arr.reduce(0){$0 + $1}
    return Double(sum) / Double(arr.count)
}

//
//  2016년.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/29.
//

import Foundation

func solution(_ a:Int, _ b:Int) -> String {
    let month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    let week = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"]
    return week[(month[0..<a - 1].reduce(0, +) + b - 1) % week.count]
}

print(solution(1, 32))

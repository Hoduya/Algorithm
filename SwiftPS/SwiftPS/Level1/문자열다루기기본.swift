//
//  문자열다루기기본.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/27.
//

import Foundation

func solution(_ s:String) -> Bool {
    return Int(s) != nil && (s.count == 4 || s.count == 6) ? true : false
}

print(solution("1234"))

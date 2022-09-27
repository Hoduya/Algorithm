//
//  서울에서김서방찾기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//

import Foundation

func solution(_ seoul:[String]) -> String {
    return "김서방은 \(seoul.firstIndex(of: "Kim")!)에 있다"
}

print(solution(["ki", "Kim"]))


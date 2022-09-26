//
//  자릿수더하기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//

import Foundation

func solution(_ n:Int) -> Int {
    return String(n).reduce(0){$0 + Int(String($1))!}
}

print(solution(7))



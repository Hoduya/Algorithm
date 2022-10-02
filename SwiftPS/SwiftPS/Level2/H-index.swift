//
//  H-index.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/02.
//

import Foundation

import Foundation

func solution(_ citations:[Int]) -> Int {
    var answer = 0
    let citations = citations.sorted(by: >)
    
    var maxH = 0
    for i in 0..<citations.count {
        let num = i + 1
        if min(num, citations[i]) > maxH {
            maxH = min(num, citations[i])
        } else {
            break
        }
    }
    return maxH;
}

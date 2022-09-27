//
//  예산.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/27.
//

import Foundation

func solution(_ d:[Int], _ budget:Int) -> Int {
    let sortedRequests = d.sorted(by: <)
    var remain = budget
    var count = 0
    
    for req in sortedRequests {
        remain -= req
        guard remain >= 0 else { break }
        count += 1
    }
    return count
}

print(solution([2,2,3,3], 10))


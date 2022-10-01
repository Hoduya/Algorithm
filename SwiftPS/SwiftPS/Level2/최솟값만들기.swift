//
//  최솟값만들기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/30.
//

import Foundation

func solution(_ A:[Int], _ B:[Int]) -> Int{
    let a = A.sorted()
    let b = B.sorted(by: >)
    
    return zip(a, b).reduce(0) { $1.0 * $1.1 }
}




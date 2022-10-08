//
//  가장큰수.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/08.
//

import Foundation

func solution(_ numbers:[Int]) -> String {
    let result = numbers.map{String($0)}.sorted{Int($0 + $1)! > Int($1 + $0)!}.joined()
 
    return result.first! == "0" ? "0" : result
}

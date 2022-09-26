//
//  문자열내p와y의개수.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/26.
//

import Foundation

func solution(_ s:String) -> Bool {
    let lowerString = s.lowercased()
    var pCnt = 0, yCnt = 0
    for c in lowerString {
        if(c == "p") {pCnt += 1}
        else if(c == "y") {yCnt += 1}
    }
    
    return pCnt == yCnt
}

func solution2(_ s: String) -> Bool {
    let string = s.lowercased()
    return s.split(separator: "p").count == string.split(separator: "y").count
}

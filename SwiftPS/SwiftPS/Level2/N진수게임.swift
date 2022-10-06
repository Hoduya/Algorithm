//
//  N진수게임.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/06.
//

import Foundation

func solution(_ n:Int, _ t:Int, _ m:Int, _ p:Int) -> String {
    var turnCount = 0
    var number = 0
    var result = ""
    var person = 0
    
    while turnCount < t {
        let numberBaseN = String(number, radix: n, uppercase: true)
        for char in numberBaseN {
            person += 1
            if person == p && turnCount < t{
                result.append(char)
                turnCount += 1
            }
            if person == m { person = 0 }
        }
        number += 1
    }
            
    return result
}

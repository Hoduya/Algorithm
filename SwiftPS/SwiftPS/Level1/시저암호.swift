//
//  시저암호.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/27.
//

import Foundation

func solution(_ s:String, _ n:Int) -> String {
    var answer = ""
    let A = Character("A").asciiValue!
    let a = Character("a").asciiValue!
    
    for char in s {
        var ascii = char.asciiValue!
        if char.isUppercase {
            ascii = (ascii - A + UInt8(n)) % 26 + A
        } else if char.isLowercase {
            ascii = (ascii - a + UInt8(n)) % 26 + a
        }
        answer += String(UnicodeScalar(ascii))
    }
    return answer
}

print(solution("AB z", 1))

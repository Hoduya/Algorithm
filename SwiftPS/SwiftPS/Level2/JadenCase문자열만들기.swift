//
//  JadenCase문자열만들기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/30.
//

func solution(_ s:String) -> String {
    var answer: String = ""
    var isFirstWord = true
    var string = s.lowercased()
    
    for char in string {
        if char == " " {
            answer += String(char)
            isFirstWord = true
        } else if isFirstWord {
            answer += String(char.uppercased())
            isFirstWord = false
        } else {
            answer += String(char)
        }
    }
    
    return answer
}

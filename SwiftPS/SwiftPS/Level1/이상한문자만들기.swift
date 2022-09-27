//
//  이상한문자만들기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/27.
//

func solution(_ s:String) -> String {
    var answer = ""
    var isEven = true
    for e in s {
        if(e == " ") {
            answer += String(e)
            isEven = true
        }
        else{
            answer += isEven ? String(e).uppercased() : String(e).lowercased()
            isEven = !isEven
        }
    }
    return answer
}


print(solution("asdf asdf ff"))

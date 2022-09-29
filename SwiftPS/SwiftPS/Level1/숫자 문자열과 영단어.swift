//
//  숫자 문자열과 영단어.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/29.
//

// 1. 문자열 한글자씩 순회
// 2. 숫자면 (int로 형변환 되면) answer append
// 3. 문자면 map에서 찾을때까지 문자 이어붙이며 순회
// 4. 찾으면 map value -> answer append
// 5. 반복

import Foundation

func solution(_ s:String) -> Int {
    var map: [String : String] = [:]
    map["zero"] = "0"; map["one"] = "1"
    map["two"] = "2"; map["three"] = "3"
    map["four"] = "4"; map["five"] = "5"
    map["six"] = "6"; map["seven"] = "7"
    map["eight"] = "8"; map["nine"] = "9"
    
    var answer: String = ""
    var numString: String = ""
    
    for char in s {
        if char.isNumber {
            answer += String(char)
        } else {
            numString += String(char)
            if let number = map[numString] {
                answer += number
                numString = ""
            }
        }
    }
    return Int(answer)!
}

func solution2(_ s: String) -> Int {
    let arr = ["zero","one","two","three","four","five","six","seven","eight","nine"]
    var str = s
    for i in 0..<arr.count {
        str = str.replacingOccurrences(of: arr[i], with: String(i))
    }
    return Int(str)!
}

print(solution2("one4seveneight"))


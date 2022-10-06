//
//  압축.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/05.
//

import Foundation

func solution(_ msg:String) -> [Int] {
    var map = [String : Int]()
    let message = msg.map{String($0)}
    var newIndex = 27
    var string = ""
    var result = [Int]()
    
    for i in 0..<26 {
        let letter = String(UnicodeScalar(65 + i)!)
        map[letter] = i + 1
    }

    for i in 0..<message.count {
        let newString = string + message[i]
        
        if let _ = map[newString] {
            string.append(message[i])
        } else {
            result.append(map[string]!)
            map[newString] = newIndex
            newIndex += 1
            string = message[i]
        }
    }
    
    if let idx = map[string] {
        result.append(idx)
    }
    
    return result
}

//
//  다트게임.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/29.
//

import Foundation

func solution(_ dartResult:String) -> Int {
    let scores = dartResult.split{ $0.isLetter || $0 == "*" || $0 == "#" }
    let letters = dartResult.split{ $0.isNumber }
    
    var roundScores = [0, 0, 0, 0]
    for (idx, score) in scores.enumerated() {
        for char in letters[idx] {
            switch char {
            case "S" : roundScores[idx + 1] = Int(score)!
            case "D" : roundScores[idx + 1] = Int(pow(Double(score)!, 2))
            case "T" : roundScores[idx + 1] = Int(pow(Double(score)!, 3))
                
            case "*" :
                roundScores[idx] *= 2
                roundScores[idx + 1] *= 2
            case "#" :
                roundScores[idx + 1] *= -1
            default :
                break
            }
        }
    }
        
    return roundScores[1...3].reduce(0, +)
}

print(solution("1T2D3D#"))


//
//  모음사전.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/08.
//

import Foundation

func solution(_ word: String) -> Int {
    var result = 0
    var count = 0
    var comb = ""
    
    func dfs(_ word: String) {
        if word == comb {
            result = count
            return
        }
        
        if comb.count == 5 {
            return
        }
        
        for char in ["A","E","I","O","U"]  {
            count += 1
            comb.append(char)
            dfs(word)
            comb.removeLast()
        }
    }
        
    dfs(word)
    return result
}

print(solution("AAAAE"))

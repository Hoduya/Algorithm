//
//  스킬트리.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/07.
//

import Foundation

func solution(_ skill:String, _ skill_trees:[String]) -> Int {
    var map = [Character : Int]()
    var answer = 0
    
    for (order, char) in skill.enumerated() { map[char] = order }
    
    for skill_tree in skill_trees {
        var preorder = -1
        var isValid = true
        for char in skill_tree {
            if let order = map[char] {
                if order == preorder + 1 {
                    preorder = order
                } else {
                    isValid = false
                    break
                }
            }
        }
        if isValid {
            answer += 1
        }
    }
    return answer
}

//
//  파일명정렬.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/07.
//

import Foundation

func solution(_ files:[String]) -> [String] {
    let files = files
    
    return files.sorted{ lhs, rhs in
        let leftHead = lhs.split{$0.isNumber}[0].lowercased()
        let rightHead = rhs.split{$0.isNumber}[0].lowercased()
        let leftNumber = Int(lhs.split{!$0.isNumber}[0])!
        let rightNumber = Int(rhs.split{!$0.isNumber}[0])!
        
        if leftHead == rightHead {
            return leftNumber < rightNumber
        }
        return leftHead < rightHead
    }
}

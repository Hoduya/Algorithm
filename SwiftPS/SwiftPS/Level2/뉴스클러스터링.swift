//
//  뉴스클러스터링.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/04.
//

import Foundation

func solution(_ str1:String, _ str2:String) -> Int {
    var pairs1 = makePairs(str1.lowercased())
    var pairs2 = makePairs(str2.lowercased())
    
    var totalCount = pairs1.count + pairs2.count
    var inCount = 0 // 교집합 개수
    var allCount = 0 // 합집합 개수
    
    for num in pairs1 {
        if let idx = pairs2.firstIndex(of: num) {
            pairs2.remove(at: idx)
            inCount += 1
        }
    }
    
    allCount = totalCount - inCount
    guard allCount > 0 else {return 65536}
    return Int(Double(inCount) / Double(allCount) * 65536)
}

func makePairs(_ string: String) -> [String]{
    let arr: [Character] = Array(string)
    var pairs = [String]()
    
    for i in 0..<arr.count - 1 {
        if arr[i].isLetter {
            if arr[i + 1].isLetter {
                pairs.append(String(arr[i]) + String(arr[i + 1]))
            }
        }
    }
    return pairs
}

print(solution("FRANCE", "french"))

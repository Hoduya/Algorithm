//
//  메뉴리뉴얼.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/17.
//

import Foundation

func solution(_ orders:[String], _ course:[Int]) -> [String] {
    var countsMap = [String : Int]()
    
    // 메뉴의 모든 조합 찾고 카운트
    func combinations(_ arr: [Character], _ idx: Int, _ str: String) {
        if course.contains(str.count) {
            if countsMap[str] == nil {
                countsMap[str] = 1
            } else {
                countsMap[str]! += 1
            }
        }
        for i in idx..<arr.count {
            combinations(arr, i + 1, str + String(arr[i]))
        }
    }
    
    // BA, AB 가 다른 메뉴 구성이 될 수 있으니 정렬 후 조합 호출
    for str in orders {
        let arr: [Character] = str.map{$0}
        combinations(arr.sorted(), 0, "")
    }
    
    // 메뉴 수 별로 최대 카운트 구성 찾기
    var result = [String]()
    for cnt in course {
        let temp = countsMap.filter{$0.key.count == cnt}
        let maxCount = temp.values.max() ?? 0
        if maxCount < 2 { continue }
        temp.forEach{
            if $0.value == maxCount {
                result.append($0.key)
            }
        }
    }
    
    return result.sorted()
}

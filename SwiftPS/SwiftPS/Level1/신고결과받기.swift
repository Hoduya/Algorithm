//
//  신고결과받기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/30.
//

import Foundation

func solution(_ id_list:[String], _ report:[String], _ k:Int) -> [Int] {
    // id_list리스트의 유저id-번호 map 만듬 (검색 최적화)
    // 각 유저의 피 신고내역. [피신고자(Int): Set[신고자(int)... ]]
    var idmap = Dictionary<String, Int>()
    var reportUsers = Dictionary<Int, Set<Int>>()
    for (num, userID) in id_list.enumerated() {
        idmap[userID] = num
        reportUsers[num] = Set<Int>()
    }
    
    // 피신고자를 신고한 유저 추가
    for repo in report {
        let reportUser = idmap[String(repo.split(separator: " ")[0])]!
        let reportedUser = idmap[String(repo.split(separator: " ")[1])]!
        
        reportUsers[reportedUser]!.insert(reportUser)
    }
    
    // 각 유저의 메일 받은 횟수
    var mailCounts = Array(repeating: 0, count: id_list.count)
    
    // 피신고자의 신고 횟수가 k 이상이라면 피신고자를 신고한 신고자들의 메일 카운트 += 1
    for (_, reportList) in reportUsers {
        if reportList.count >= k {
            reportList.forEach{ mailCounts[$0] += 1}
        }
    }
    
    return mailCounts
}

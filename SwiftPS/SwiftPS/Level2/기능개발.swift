//
//  기능개발.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/04.
//

import Foundation

func solution(_ progresses:[Int], _ speeds:[Int]) -> [Int] {
    var releaseDates = [Int]()
    for (idx, progress) in progresses.enumerated() {
        let date = Int(ceil(Double(100 - progress) / Double(speeds[idx])))
        releaseDates.append(date)
    }
    
    var result = [Int]()
    var isGroupChecking = false
    var groupReleaseDate = 0
    var groupCount = 0
    for releaseDate in releaseDates {
        if isGroupChecking {
            if groupReleaseDate < releaseDate {
                result.append(groupCount)
                isGroupChecking = false
            }
            else {
                groupCount += 1
            }
        }
        
        if !isGroupChecking {
            groupReleaseDate = releaseDate
            groupCount = 1
            isGroupChecking = true
        }
    }
    result.append(groupCount)
    
    return result
}

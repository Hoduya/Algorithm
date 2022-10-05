//
//  주차 요금 계산.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/05.
//

import Foundation

func solution(_ fees:[Int], _ records:[String]) -> [Int] {
    var totalMinutes = [String : Int]()
    var inTimes = [String: String]()
    
    // 0: 시간, 1: 번호, 2: 입출
    for string in records {
        let info = string.split(separator: " ").map{String($0)}
        switch info[2] {
            case "IN":
            inTimes[info[1]] = info[0]
            
            case "OUT":
            var minutes = getMinutes(inTimes[info[1]]!, info[0])
            minutes += totalMinutes[info[1]] ?? 0
            totalMinutes[info[1]] = minutes
            inTimes[info[1]] = nil
            
            default:
            break
        }
    }
    
    for (_, inTimes) in inTimes.enumerated() {
        var minutes = getMinutes(inTimes.value, "23:59")
        minutes += totalMinutes[inTimes.key] ?? 0
        totalMinutes[inTimes.key] = minutes
    }
    
    let totalFees = totalMinutes.sorted{ $0.key < $1.key}.map{calcFee($0.value, fees)}
    
    return totalFees
}
func getMinutes(_ inTime: String, _ outTime: String) -> Int{
    let inTimes = inTime.split(separator: ":")
    let outTimes = outTime.split(separator: ":")

    var minutes = (Int(outTimes[0])! - Int(inTimes[0])!) * 60
    minutes += Int(outTimes[1])! - Int(inTimes[1])!
    
    return minutes
}

func calcFee(_ minutes: Int, _ fees: [Int]) -> Int {
    guard minutes > fees[0] else {return fees[1]}
    return fees[1] + Int(ceil(Double(minutes - fees[0]) / Double(fees[2]))) * fees[3]
}

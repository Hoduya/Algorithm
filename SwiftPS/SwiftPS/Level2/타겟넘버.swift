//
//  타겟넘버.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/05.
//

import Foundation

var count = 0
var nums = [Int]()
func solution(_ numbers:[Int], _ target:Int) -> Int {
    nums = numbers
    dfs(target,0, 0)
    
    return count
}

func dfs(_ target: Int, _ idx: Int, _ sum: Int) {
    if idx == nums.count {
        if sum == target { count += 1 }
        return
    }
    
    dfs(target, idx + 1, sum + nums[idx])
    dfs(target, idx + 1, sum - nums[idx])
}

print(solution([1, 1, 1, 1, 1]    , 3))

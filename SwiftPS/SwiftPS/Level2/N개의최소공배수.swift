//
//  N개의최소공배수.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/01.
//

func solution(_ arr:[Int]) -> Int {
    if arr.count < 2 {return arr[0]}
    
    var lcm = 1
    for i in 0..<arr.count - 1 {
        lcm = LCM(lcm, LCM(arr[i], arr[i + 1]))
    }

    return lcm
}

func GCD(_ a: Int, _ b: Int) -> Int{
    if b == 0 { return a }
    return GCD(b, a % b)
}

func LCM(_ a: Int, _ b: Int) -> Int {
    return a * b / GCD(a, b)
}

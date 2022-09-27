//
//  직사각형별찍기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/27.
//

import Foundation

let n = readLine()!.components(separatedBy: [" "]).map { Int($0)! }
let (w, h) = (n[0], n[1])

for _ in 0..<h {
    for _ in 0..<w {
        print("*", terminator: "")
    }
    print()
}

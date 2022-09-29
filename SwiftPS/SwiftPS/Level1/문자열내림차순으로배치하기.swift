//
//  문자열내림차순으로배치하기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/27.
//

import Foundation

func solution(_ s:String) -> String {
    return String(Array(s).sorted(by: > ))
}

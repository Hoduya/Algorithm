//
//  카펫.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/01.
//

import Foundation

func solution(_ brown:Int, _ yellow:Int) -> [Int] {
    // 테두리 개수 C, 가로 길이 W, 세로 길이 H 일때
    // C / 2 + 2 = W + H
    // 위를 만족하는 W, H의 경우의 수를 모두 고려하여 yellow수가 들어가는지 Check
    // Yello의 개수 Y = (W - 2) * (H - 2)
    var len = (w : 3, h : 3)
        
    len.w = (brown / 2 + 2) - len.h
    
    while(len.w >= len.h) {
        if yellow == (len.w - 2) * (len.h - 2) {
            break
        }
        len.w -= 1
        len.h += 1
    }
    
    return [len.w, len.h]
}

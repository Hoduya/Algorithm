//
//  키패드누르기.swift
//  SwiftPS
//
//  Created by HoJun on 2022/09/30.
//

import Foundation

enum TapHand: String {
    case left = "L"
    case right = "R"
}

func solution(_ numbers:[Int], _ hand:String) -> String {
    var result: String = ""
    let handType: TapHand = hand == "right" ? .right : .left
    var leftHand = 10
    var rightHand = 12
    var tapHand: TapHand
    
    for num in numbers {
        let num = num == 0 ? 11 : num
        switch num {
            case 3, 6, 9:
            tapHand = .right
            
            case 1, 4, 7:
            tapHand = .left
            
            default:
            let rDist = abs(num - rightHand) / 3 + abs(num - rightHand) % 3
            let lDist = abs(num - leftHand) / 3 + abs(num - leftHand) % 3
        
            if(rDist == lDist) { tapHand = handType }
            else { tapHand = rDist < lDist ? .right : .left}
        }
        
        switch tapHand {
        case .right:
            rightHand = num
        case .left:
            leftHand = num
        }
        result += tapHand.rawValue
    }
    
    return result
}



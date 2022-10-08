//
//  방문길이.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/07.
//

import Foundation

struct Visit {
    var up = false
    var down = false
    var right = false
    var left = false
}

struct Point {
    var x: Int
    var y: Int
}

func solution(_ dirs: String) -> Int {
    var visit = Array(repeating: Array(repeating: Visit(), count: 11), count: 11)
    var count = 0
    
    var cur = Point(x: 5, y: 5)
    for char in dirs {
        switch char {
        case "U":
            guard cur.y < 10 else { continue }
            visit[cur.y][cur.x].down = true
            cur.y += 1
            guard !visit[cur.y][cur.x].up else { continue }
            visit[cur.y][cur.x].up = true

        case "D":
            guard cur.y > 0 else { continue }
            visit[cur.y][cur.x].up = true
            cur.y -= 1
            guard !visit[cur.y][cur.x].down else { continue }
            visit[cur.y][cur.x].down = true

        case "R":
            guard cur.x < 10 else { continue }
            visit[cur.y][cur.x].left = true
            cur.x += 1
            guard !visit[cur.y][cur.x].right else { continue }
            visit[cur.y][cur.x].right = true

        case "L":
            guard cur.x > 0 else { continue }
            visit[cur.y][cur.x].right = true
            cur.x -= 1
            guard !visit[cur.y][cur.x].left else { continue }
            visit[cur.y][cur.x].left = true
            
        default:
            break
        }
        count += 1
    }
    return count
}

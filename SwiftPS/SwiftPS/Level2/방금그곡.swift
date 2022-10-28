//
//  방금그곡.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/24.
//

import Foundation

struct Music {
    static var count = 0
    
    let order: Int = Music.count
    let start: String
    let end: String
    let title: String
    let playTime: Int
    var notes: String
}

func solution(_ m:String, _ musicinfos:[String]) -> String {
    var musics = [Music]()
    
    for music in musicinfos {
        let arr = music.components(separatedBy: ",")
        
        // 재생 시간
        let playTime = { () -> Int in
            let s = arr[0].split(separator: ":").map{Int($0)!}
            let e = arr[1].split(separator: ":").map{Int($0)!}
            
            return (e[0] * 60 + e[1]) - (s[0] * 60 + s[1])
        }()
        
        // 악보 배열
        var noteArray = [String]()
        for note in arr[3] {
            if note == "#" {
                noteArray[noteArray.endIndex - 1] += "#"
            } else {
                noteArray.append(String(note))
            }
        }
        
        // 재생 시간 맞춘 악보 문자열
        var notesInTime = ""
        for i in 0..<playTime {
            let idx = i % noteArray.count
            notesInTime.append(noteArray[idx])
        }
        
        musics.append(Music(start: arr[0], end: arr[1], title: arr[2], playTime: playTime, notes: notesInTime))
        Music.count += 1
    }
    
    // m 을 담고있는 음악정보만 남김
    musics = musics.filter{
        let tempArr = $0.notes.components(separatedBy: m + "#")
        for notes in tempArr {
            if notes.contains(m) { return true }
        }
        return false
    }
    
    guard musics.count != 0 else {return "( None )"}
    return musics.sorted { lhs, rhs in
        if lhs.playTime == rhs.playTime {
            return lhs.order < rhs.order
        } else {
            return lhs.playTime > rhs.playTime
        }
    }.first!.title
}
print(solution("ABC" , ["12:00,00:00,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]))



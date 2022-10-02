//
//  캐시.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/02.
//

func solution(_ cacheSize:Int, _ cities:[String]) -> Int {
    // cache 없는 경우
    if cacheSize == 0 { return cities.count * 5 }
    
    var time = 0
    var cache = [String]()
    
    for city in cities {
        var city = city.lowercased()
        // Hit
        if let hitIndex = cache.firstIndex(of: city) {
            cache.remove(at: hitIndex)
            cache.append(city)
            time += 1
        }
        // Miss
        else {
            // cache에 자리가 남는 경우
            if cache.count < cacheSize {
                cache.append(city)
            }
            // cache가 가득 찬 경우
            else {
                cache.removeFirst()
                cache.append(city)
            }
            time += 5
        }
    }
    
    return time
}

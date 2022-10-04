//
//  프린터.swift
//  SwiftPS
//
//  Created by HoJun on 2022/10/04.
//

import Foundation

func solution(_ priorities:[Int], _ location:Int) -> Int {
    var queue = Queue<(priority: Int, isRequested: Bool)>()
    let sotedPriorities = priorities.sorted(by: >)
    var maxIndex = 0
    var popCount = 0
    
    for i in 0..<priorities.count {
        queue.enqueue((priorities[i], i == location ? true: false))
    }
        
    while(!queue.isEmpty) {
        if let popItem = queue.dequeue() {
            if popItem.priority >= sotedPriorities[maxIndex] {
                popCount += 1
                maxIndex += 1
                if popItem.isRequested { break }
            } else {
                queue.enqueue(popItem)
            }
        }
    }
    
    return popCount
}

struct Queue<T> {
    private var array = [T?]()
    private var head = 0
    
    var isEmpty: Bool {
        return count == 0
    }
    
    var count: Int {
        return array.count - head
    }
    
    mutating func enqueue(_ element: T) {
        array.append(element)
    }
    
    mutating func dequeue() -> T?{
        guard head < array.count, let element = array[head] else {return nil}
        array[head] = nil
        head += 1
        
        return element
    }
}

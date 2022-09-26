func solution(_ n:Int) -> Int {
    var sum = 1
    for num in 2...n {
        if(n.isMultiple(of: num)) {sum += num}
    }
    
    return sum
}

print(solution(10))

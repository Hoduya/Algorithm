import Foundation

func solution(_ a:Int, _ b:Int) -> Int64 {
    return Int64((abs(a - b) + 1) * (a + b) / 2)
}

print(solution(3, 4))

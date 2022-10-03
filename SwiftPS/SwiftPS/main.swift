import Foundation

func solution(_ n:Int, _ left:Int64, _ right:Int64) -> [Int] {
    let left = Int(left)
    let right = Int(right)
    
    
    var answer = [Int]()
    
    for i in left...right {
        let row = i / n + 1
        let col = i % n + 1
        answer.append(row > col ? row : col)
    }
    
    return answer
}
print(solution(3, 0, 8))
/*
    1 2 3 4
    2 2 3 4
    3 3 3 4
    4 4 4 4
    
    1 2 3 4 2 2 3 4 3 3 3  4 4 4 4
    0 1 2 3 4 5 6 7 8 9 10 11
    
    i 번째 요소는 (i % n),
    단 (i % n) < ((i / n) + 1) 일 경우 (i / n) + 1
 
    i 는
    1 2 3 2 2 3 3 3
    
    
 */

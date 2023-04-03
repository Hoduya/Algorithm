import Foundation

func solution(_ numbers:[Int]) -> String {
    let result = numbers.map{String($0)}.sorted{Int($0 + $1)! > Int($1 + $0)!}.joined()
 
    return result.first! == "0" ? "0" : result
    
    
}
print(solution([3, 30, 34, 5, 9]))

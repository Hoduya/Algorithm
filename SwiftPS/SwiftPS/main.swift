func solution(_ m:Int, _ n:Int, _ board:[String]) -> Int {
    var isblank = Array(repeating: Array(repeating: false, count: n), count: m)
    var board = board.map{Array($0)}
    var score = 0
    let dx = [0, 1, 1, 0]
    let dy = [0, 0, 1, 1]
    var isChanged = true

    while isChanged {
        isChanged = false
        for i in 0..<m - 1 {
            for j in 0..<n - 1 {
                guard board[i][j] != "X" else {continue}
                let symbol = board[i][j]
                var isFourSame = true
                for k in 0..<4 {
                    let tx = dx[k] + j
                    let ty = dy[k] + i
                    if symbol != board[ty][tx]{
                        isFourSame = false
                        break
                    }
                }
            
                if isFourSame {
                    for k in 0..<4 {
                        let tx = dx[k] + j
                        let ty = dy[k] + i
                        if !isblank[ty][tx] {
                            score += 1
                            isChanged = true
                        }
                        isblank[ty][tx] = true
                    }
                }
            }
        }
    
        for i in 0..<m-1 {
            for j in 0..<n {
                guard !isblank[i][j] else {continue}
                var nextRow = i + 1
                while nextRow < m {
                    if isblank[nextRow][j] {
                        board[nextRow][j] = board[i][j]
                        board[i][j] = "X"
                        isblank[nextRow][j] = false
                        isblank[i][j] = true
                        break
                    }
                    nextRow += 1
                }
            }
        }
        
        for i in 0..<m {
            for j in 0..<n {
                if isblank[i][j] {
                    board[i][j] = "X"
                }
            }
        }
    }
    return score
}

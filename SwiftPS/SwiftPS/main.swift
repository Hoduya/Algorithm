import Foundation

func solution(_ s:String) -> Int {
    let arr = Array(s)
    var compMax = 0

    for len in 1...(arr.count / 2) + 1{
        var preStr = ""
        var repeatCount = 0
        var compLength = 0
        for left in stride(from: 0, to: arr.endIndex, by: len) {
            let right = left + len - 1
            guard right < arr.endIndex else { continue }
            
            let compRange = left...right
            let str = String(arr[compRange])

            if str == preStr {
                repeatCount += 1
            } else {
                if repeatCount > 0 {
                    compLength += (len * repeatCount) - 1
                }
                repeatCount = 0
            }
            preStr = str
        }
        
        if repeatCount > 0 { compLength += (len * repeatCount) - 1 }
        repeatCount = 0
        
        compMax = max(compMax, compLength)
    }
    return arr.count - compMax
}

print(solution("werwerwsdgsdfsdfsdf"))

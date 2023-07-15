#입력
N, X = map(int, input().split(" "))
arr = list(map(int, input().split(" ")))

#문자열
# 소수점 지정
format(1.2345, ".1f")

# 앞 뒤 공백 제거
"   abc   ".strip()

#이진 탐색
import bisect
arr = [1, 2, 2, 3]
target = 2
bisect.bisect_left(arr, target) # LowerBOund
bisect.bisect_right(arr, target) # UpperBound

#math
import math
# 제곱근
math.sqrt(16)
root16 = 16**(1/2)
# 올림, 내림
math.ceil(3.14)
math.floor(3.14)

#정렬
arr.sort(reverse=True) # 내림차순

#배열
# 2차원배열 초기화
arr2 = [[0 for j in range(0, 10)] for i in range(0, 10)]
arr2 = [[0] * 10 for _ in range(10)]
# 배열 마지막 인덱스 값
arr[-1]
# 배열 뒤집기
arr[::-1] # 뒤집은 배열 리턴
arr.reverse() # 뒤집기

#ASCII
ord('A')
chr(65)

#큐
from collections import deque
queue = deque()
queue.append(1)
queue.popleft()
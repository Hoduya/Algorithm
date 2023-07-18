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
sorted_arr = sorted(arr, reverse=True) # 정렬된 새로운 리스트 생성
arr.sort(key=lambda x:(-x[0], x[1])) # 리스트의 원소(튜플)의 첫번째 인자는 내림차순을, 두번째는 오름차순을 기준으로 정렬 -> e.g) 길이가 같다면, 번호가 작은것이 먼저 뽑혀야함...

#배열
# 배열 초기화
arr = [i for i in range(10)] # 1,2,3,4...
arr = [0] * 10 # 0...

# 2차원배열 초기화
arr2 = [[0 for j in range(0, 10)] for i in range(0, 10)]
arr2 = [[0] * 10 for _ in range(10)]
# 배열 마지막 인덱스 값
arr[-1]
# 배열 뒤집기
arr[::-1] # 뒤집은 배열 리턴
arr.reverse() # 뒤집기

#Set
list(set(arr)) # 배열 중복 제거
s = set()
set.add(s, 1)

#ASCII
ord('A')
chr(65)

#큐
from collections import deque
queue = deque()
queue.append(1)
queue.popleft()

#딕셔너리
dic = {}
dic['key'] = 'value'
if 'key' in dic: # 딕셔너리에 해당 키 생성되었는지 확인.
    print('find!')

#힙
import heapq
heap = []
heapq.heappush(heap, 1)
heapq.heappop(heapq) # 최소값 뽑기
heap[0] # 최소값 확인

# 조합, 순열
import itertools
comb = itertools.combinations(arr, 2)
perm = itertools.permutations(arr, 2)

#재귀 깊이 제한 해제
import sys
sys.setrecursionlimit(10**6)

# 다시풀어 볼 문제
# 뒤에있는 큰 수 찾기
N = int(input())
P = list(map(int, input().split()))

# 로직

# 1.오름차순 정렬 후 차례대로 더하기
# 2.첫번쨰 사람은 자기 자신, 두번쨰 사람은 첫번쨰 사람 + 자기자신
# ex) 3명 -> 1 2 3
# sum1 = 1, sum2 = 1 + 2 .... (sum1 + sum2... sumN)

P.sort()
sum = 0  # 이전 사람이 기다린 시간
totalSum = 0  # 각 사람이 줄을 서서 기다린 모든 시간의 총합
for i in P:
    sum += i
    totalSum += sum

print(totalSum)

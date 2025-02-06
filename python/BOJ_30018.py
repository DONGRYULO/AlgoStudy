# <문제이해>
# 모든 자전거를 대여소에 반납 -> 유실된 자전거는 없음 (모든 자전거가 다시 대여소에 반납되지만 대여소 설치 당시에 보관된 자전거 개수와 달라질 수 있음)

# <예시>
# N(3)개의 대여소 설치
# 각 대여소에 자전거 설치 -> A : 1, B : 1, C : 5
# 대여소에 자전거 반납 -> A : 4, B : 2, C : 1
# 대여소 설치 당시 자전거의 개수로 만들기 위해 최소 몇번 옮겨야 하는지? (자전거는 한대씩 이동 가능)
# A에 있는 자전거 3개를 C로 이동 (3번) + B에 있는 자전거 1개를 C로 이동(1번) = 4번

# <로직>
# 자전거의 개수를 보관해주는 변수를 만들어 반납 이후 자전거가 많으면 증감해주고 반납 이후 자전거가 적으면 감소시킴
# 1. 대여소 자건거 설치 후와 반납 후의 개수를 비교
# 1.1. 반납 후의 개수가 더 많은 경우 자전거의 개수가 동일할 때 까지 차감 -> 자전거 보관 변수 카운트 증가(카운트 만큼 이동횟수 증가)
# 1.2. 반납 후의 개수가 더 적은 경우 자전거의 개수가 동일할 때 까지 증감 -> 자전거 보관 변수 카운트 감소

# keepBicyleCnt = 0, minMoveCnt = 0
# 3 1 4 2
# 2 2 3 3
# 3 <> 2 : keepBicyleCnt = -1
# 1 <> 2 이동: keepBicyleCnt = 0, minMoveCnt = 1
# 4 <> 3 : keepBicyleCnt = -1
# 2 <> 3 이동: keepBicyleCnt = 0, minMoveCnt = 2

# 1 1 5
# 4 2 1
# 1 <> 4 이동: keepBicyleCnt = 3, minMoveCnt = 3
# 1 <> 2 이동: keepBicyleCnt = 4, minMoveCnt = 4
# 5 <> 1 : keepBicyleCnt = 0, minMoveCnt = 4

# 반납 후의 개수가 더 많은 경우에만 이동 횟수가 증가하므로 자전거 보관 변수는 필요없음

N = int(input())
bicycleSetUp = list(map(int, input().split()))
bicycleReturn = list(map(int, input().split()))

minMoveCnt = 0
for i in range(N):
    if bicycleReturn[i] > bicycleSetUp[i]:
        minMoveCnt += bicycleReturn[i] - bicycleSetUp[i]

print(minMoveCnt)

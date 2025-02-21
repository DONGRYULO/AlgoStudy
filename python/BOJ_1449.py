# 물을 막을때 테이프 길이는 최소 좌우 0.5 간격 필요
# 물을 막기위한 테이프의 최소 개수 구하기
# 테이프 겹쳐서 붙이기 가능

# 물 새는 곳 하나당 -> 1cm 테이프 필요
# 1,2 -> 1.5cm 필요
# 1,3 -> 2cm 필요
# 위치가 붙어있는 경우는 다른 방식으로 계산 필요
# Q. 위치가 붙어있는지 코드상으로 어떻게 구현하지?
# flag 초기값을 0, 감산할 테이프 변수 A=0 으로 두고 배열을 순회
# 1. flag가 0이면 flag를 해당 값으로 변경
# 2. flag가 0이 아니면 현재 값에서 -1를 한값이 이전 인덱스의 값과 동일한지 체크
# 2.1. 동일하면 A = A + 0.5
# 2.2. 다르면 flag을 0, A = 0 초기화

# 1,2 -> 0.5cm(2-1.5) 차감
# 1,2,3 -> 1cm(3-2) 차감
# 1,2,3,4 -> 1.5cm(4-2.5) 차감

# 1,2, 100, 101 -> 1cm 테이프 2 or 2cm 테이프 2
# 물 새는 곳 개수 4개 -> 4cm(a)
# a에서 테이프 길이를 계속 빼면서 0이하가 나오는 지점에 테이프 숫자를 계산
# 4-2 = 2(1개) , 2-2 = 0(1개) --> 총 2개

# 1, 2,3,4
# 물 새는 곳 개수의 총 길이 4cm(a) -> 테이프 길이 3cm
# 4-3 = 1(1개) , 1-3 = -2(1개) --> 총 2개

# 입력예시는 모두 정답인데 어떤 경우에 오답이 발생하는가?

# N:물새는 곳 개수  L:테이프 길이
N, L = map(int, input().split(' '))
# pos : 물 새는 곳 위치
pos = list(map(int, input().split(' ')))
pos.sort()

cnt = 0
covered = 0
for i in range(N):
    if(pos[i] > covered): # 시작위치부터 붙인 테이프가 커버하지 못하면 테이프를 붙이기
        cnt += 1
        covered = pos[i] + L - 1 # 시작위치부터 L만큼의 테이프를 붙임

print(cnt)

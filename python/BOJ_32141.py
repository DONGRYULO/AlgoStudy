# 걸린시간 : 1시간
# 최대한 늦게 상대를 죽이는 카드의 최대 개수
# 모든 카드를 사용해도 죽일 수 없으면 -1 출력

# H = 5, ds = [1, 2, 3]
# H = 5, ds = [1, 1, 1, 2, 3]
# 1. ds의 조합으로 H를 0이하로 만들수 있는가?
# 첫번쨰 인덱스부터 차례대로 H를 빼가면서 최초로 H가 0이하가 발생하는 카드 개수 체크

# 2. 카드를 가장 많이 사용한 조합은 무엇인가?
# N개의 카드가 있을 때, N개의 카드 모두를 사용한 경우
# 만약에 N개의 카드를 모두 사용하지 못하면 N-1, N-2 ... 1개의 카드를 사용한 경우가 최대가 된다.

# solutin 1)
# 시간초과 발생
# 바깥쪽 for문 -> O(N), 안쪽 for문 -> O(N) --> O(n*n)
# 일반적으로 온라인 알고리즘 사이트에서 1초에 최대 1억 연산을 수행할 수 있음을 가정
# O(n:10의6승) -> 1초에 최대 백만이므로 허용
# O(n*n) -> 1초에 최대 1조 연산(10의 12승)이므로 시간초과 발생

N, H = map(int, input().split())
ds = list(map(int, input().split()))

maxUseCnt = 0

for i in range(N):
    j = i
    result = H
    useCnt = 0
    # N개의 카드가 있는 경우 N, N-1, .. 1개일 때 각각 0이 될 수 있는 조합을 구할 필요가 없음
    # 왜? 이런 방식으로 생각했을까?
    for j in range(N):
        result = result - ds[j]
        useCnt += 1
        if (result <= 0):
            if (useCnt > maxUseCnt):
                maxUseCnt = useCnt
            break

if (maxUseCnt == 0):
    print(-1)
else:
    print(maxUseCnt)


# solutin 2)
N, H = map(int, input().split())
ds = list(map(int, input().split()))

useCnt = 0
for i in range(N):
    # 오름차순으로 입력값이 주어졌기 때문에 0번쨰 인덱스에 있는 수부터 차례대로 빼보면서 0이하가 되는 지점의 개수를 구하면 됨
    # H=5 [1,4,5] -> 1 + 4(0이하가 되는 지점) + 5 -> 2개
    # H=5 [5,4,1] -> 5(0이하가 되는 지점) + 4 + 1 -> 1개(내림차순인 경우에는 문제가 달라지므로 정렬이 필요)
    H = H - ds[i]
    useCnt += 1
    if (H <= 0):
        print(useCnt)
        exit()

print(-1)

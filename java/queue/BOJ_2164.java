package queue;

/*
    1회차)
    걸린시간 : 10:30 ~ 11:10
    풀이방법 참고 : X
    이해 여부 : O
*/

/*
    1(front) -> 2 -> 3 -> 4(tail)

    0. 원소가 1개라면 출력 후 프로그램 종료
    1. front에 있는 원소 제거 (만약 원소가 1개만 남았으면 출력 후 프로그램 종료)
    - [1 -> 2 -> 3]
    2. 그 다음 front에 있는 원소 peek 하고 제거 후 tail에 넣음
    - [3 -> 2]
*/

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // 로직
        while(queue.size() != 1){
            queue.poll();
            if(queue.size() == 1) break;

            int frontValue = queue.poll();
            queue.offer(frontValue);
        }
        System.out.println(queue.poll());
    }
}

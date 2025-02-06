package deque;
/*
    1회차)
    걸린시간 : 13:17(시작) ~ 16:20(종료)
    풀이방법 참고 : O
    이해 여부 : X
*/

/*
    1. 첫번째 연산
    front_pop
    2. 두번쨰 연산
    front_peek 이후 front_pop 하고 해당 데이터를 offerLast 연산
    3. 세번쨰 연산
    back_peek 이후 back_pop 하고 해당 데이터를 offerFirst 연산

    Q. 연산은 언제 수행되어야 하나?
    원소를 주어진 순서대로 뽑는데 드는 2번과 3번 연산의 최솟값 구하기
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class BOJ_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 큐의 크기
        int M = sc.nextInt(); // 뽑을 수의 개수

        // ex) N(자연수)=5, M=3
        // [1,2,3,4,5]
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        int cnt = 0; // 최솟값
        for(int i=0;i<M;i++){
            int pos = sc.nextInt();

            // 뽑으려고 하는 원소가 있는 위치를 반복자를 돌려서 찾기
            int idx = 0;
            Iterator<Integer> dequeList = deque.iterator();
            while(dequeList.hasNext()){
                int findValue = dequeList.next();
                if(pos == findValue) break;
                idx++;
            }

            // peek를 해보고 뽑아내려고 하는 위치가 맞으면 pop
            while(deque.peekFirst() != pos){
                // 뽑아내려고 하는 위치가 맞지 않으면 2번과 3번 연산중에 어떤 것이 더 빠른 방법인지 체크
                // idx가 "deque.size() - idx" 보다 작으면 앞쪽에서 접근하는게 효율적인게 이해가 안됨
                if(idx < deque.size() - idx){ // 2번 연산(뽑아낼 위치가 앞쪽에서 접근하는게 더 가까운 경우)
                    deque.offerLast(deque.peekFirst());
                    deque.pollFirst();
                }else{
                    deque.offerFirst(deque.peekLast());
                    deque.pollLast();
                }
                cnt++;
            }
            deque.pollFirst();
        }

        System.out.println(cnt);
    }
}

package deque;

/*
    걸린시간)
    09:15 ~ 11

    문제이해)
    1. R -> 순서 뒤집기
    [1, 2, 3] 뒤집기 전에는 시작 인덱스가 deque의 head(front)인 1을 가리키고, 뒤집으면 시작 인덱스를 deque의 tail(back)인 3으로 잡음

    2. D -> 현재 가리키고 있는 인덱스를 기준으로 제거
    시작 인덱스가 front를 가리킨다면 pollFirst or back을 가리킨다면 pollLast 사용
    단, 배열이 비어있는 경우에는 error를 뱉기
*/

import java.util.*;

public class BOJ_5430 {

    static void parse(String[] tmpArr, Deque<Integer> dq){
        int cur = 0;
        for(int i=1;i<tmpArr.length-1;i++){
            if(tmpArr[i].equals(",")){
                dq.offerLast(cur);
                cur = 0; // "," 단위로 숫자가 구분되므로 다음 계산을 위해 초기화
            }else{
                // 문자로 입력된 값을 아스키 코드표에 의해서 정수로 변환
                // "10 * cur" 의미는 문자로 된 숫자가 연달아서 올 때 계산하기 위함
                cur = 10 * cur + (tmpArr[i].charAt(0) - '0');
            }
        }
        // 맨 마지막 숫자는 for문에서 큐에 들어가지 않았기 때문에 추가적으로 넣어줌
        if(cur != 0) dq.offerLast(cur);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            String p = sc.next(); // 수행할 함수
            String[] pArr = p.split("");
            int arrCnt = sc.nextInt(); // 배열에 들어있는 개수
            String tmp = sc.next(); // [1,2,3] 이렇게 값이 들어감
            String[] tmpArr = tmp.split("");

            Deque<Integer> DQ = new ArrayDeque<>(); // 배열에 들어있는 정수
            // 입력
            parse(tmpArr, DQ);

            // 로직
            boolean isHead = true; // head를 가리키는지 tail을 가리키는지 체크
            boolean isWrong = false;
            for(int i=0;i<pArr.length;i++){
                if(pArr[i].equals("R")){
                    isHead = (isHead == true) ? false : true;
                }else if(pArr[i].equals("D")){
                    if(DQ.isEmpty()){
                        isWrong = true;
                        break;
                    }

                    if(isHead){ // true -> head
                        DQ.pollFirst();
                    }else if(!isHead){ // false -> tail
                        DQ.pollLast();
                    }
                }
            }

            // 출력
            if(isWrong){
                System.out.println("error");
            }else{
                StringBuilder sb = new StringBuilder("[");
                while(!DQ.isEmpty()){
                    if(isHead){
                        sb.append(DQ.pollFirst());
                    }else{
                        sb.append(DQ.pollLast());
                    }

                    if(!DQ.isEmpty()){
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }

    }
}



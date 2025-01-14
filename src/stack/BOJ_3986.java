package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
    case)
    1. ABAB (X)
    -> ({)}
    A끼리 B끼리 선을 긋는데 선이 교차되므로 좋은 단어가 아님
    2. AABB (O)
    (){}
    3. ABBA (O)
    ({})
    4. AA (O)
    ()

    how 좋은 단어를 선별 할 수 있는가?
    1. A와 B의 디폴트 값을 (, { 두고 시작한다. 
    첫번째로 A가 나오면 "(" 기호를 사용하고, 그 다음에 A가 한번 더 나오면 ")" 기호를 사용한다.
    A와 B에 대해서 flag 변수를 두어서 flag가 true면 여는 괄호 false면 닫는 괄호로 인식하기

*/
public class BOJ_3986 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int goodCnt = 0;

        // 로직
        while(N-- > 0){
            String[] word = sc.next().split("");
            Deque<String> stack = new ArrayDeque<>();

            for(String s : word){
                // ex) ABA -> stack(A,B) 맨 마지막 A를 체크할 때, 결과적으로 stack(A,B,A)에 값이 비워지지 않기 때문에 좋은 단어가 아님
                if(!stack.isEmpty() && stack.peek().equals(s)){
                    stack.pop();
                }else{
                    stack.push(s);
                }
            }

            if(stack.isEmpty()) goodCnt++;
        }

        // 출력
        System.out.println(goodCnt);
    }
}

































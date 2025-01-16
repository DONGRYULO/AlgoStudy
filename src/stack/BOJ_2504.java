package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
    ## 목차
    구현시간 : 3시간
    풀이방법 참고 : X
    이해 여부 : X
    난이도 : 상

    ## 문제이해
    올바른 괄호열 x에 대해서 그 괄호값을 5가지로 정의하고 값 x로 표시
    - 한쌍의 괄호열이면 올바른 괄호열(x)
    1. () = x -> 2
    2. [] = x -> 3
    3. (()) -> 2 * x(2) = 4
    4. [[]] -> 3 * x(3) = 9
    5. x와 y가 결합된 형태? ****
    ex) () [[]] -> 2(x) + 9(y)

    ( () [[]] ) -> 2 * 11(xy)
    ([]=x) -> 2 * 3(x)

    단, 입력이 올바르지 못한 괄효열이면 0 출력

    ## 구현

    1. "(", "[" 들어오면 stack에 push

    2. ")" 일 때, 이전에 있는 괄호열이 "[" or stack이 비어있으면 올바르지 못한 괄호열
    2.1. top에 있는 괄호가 "(" 경우 pop 처리
    - case1. 스택이 비어있으면 int x = 0을 2로 초기화
    ex) ()
    - case2. x값이 0이 아니라면, x = x * 2
    ex)  ( () )

    2.2 이전에 있는 괄호가 "]"인 경우 "x+y" 수행후 x에 넣고 (int x = x + y) pop 처리
    - case1. x값이 0이 아니라면, x = x * 2
    ex) ( () [[]] )
    x = (x+y) * 2

    ex) (( () [[]] ))
    x = (x+y) * 2
    x = ((x+y) * 2) * 2

    ex) (( () [[]] ) -> X(맨마지막 까지 괄호를 체크했을 때, stack에 값이 비어있는지 체크 수행 후 비어있지 않으면 올바르지 못한 괄호)


    3. "]" 일 때, top에 있는 괄호열이 "["아니거나 stack이 비어있으면 올바르지 못한 괄호열
    3.1. top에 있는 괄호가 "[" 경우 pop 처리
    - case1. 스택이 비어있으면 int y = 0을 3로 초기화
    ex) []
    - case2. y값이 0이 아니라면, y = y * 3
    ex)  [ [] ]

    4. x와 y가 결합된 형태
    case1. 마지막 괄호가 "]"인 경우 x값이 0이 아니라면, "x + y" 조합
    ex) () [[]] -> 2(x) + 9(y)

    case2. 마지막 괄호가 ")"인 경우 y값이 0이 아니라면, "y + x" 조합
    ex) [[]] () -> 9(y) + 2(x)
 */
public class BOJ_2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");

        int cnt = 0; // 출력 변수
        int x = 0;
        int y = 0;

        // ( (2) [[9]] ) ([])
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<input.length;i++){
            if(input[i].equals("(") || input[i].equals("[")){
                stack.push(input[i]);
            }else if(input[i].equals(")")){
                if(stack.isEmpty() || stack.peek().equals("[")){
                    cnt = 0;
                    break;
                }else if(stack.peek().equals("(")){ // ( () ), ()
                    stack.pop();
                    if(stack.isEmpty()){
                        cnt = cnt + ((x + y) * 2);
                        // 초기화
                        x = 0;
                        y = 0;
                        continue;
                    }
                    if(x == 0) x = 2;
                    else x = x * 2;
                }else if(input[i-1].equals("]")){ // ( () [[]] )
                    stack.pop();
                    x = (x + y) * 2;
                }
            }else if(input[i].equals("]")){
                if(stack.isEmpty() || stack.peek().equals("(")){
                    cnt = 0;
                    break;
                }else if(stack.peek().equals("[")){ // [ [] ], []
                    stack.pop();
                    if(stack.isEmpty()){
                        cnt = cnt + ((x + y) * 3);
                        // 초기화
                        x = 0;
                        y = 0;
                        continue;
                    }
                    if(y == 0) y = 3;
                    else y = y * 3;
                }else if(input[i-1].equals(")")){ // [ () ] -> 2 * 3, [ [] () ] -> (3+2)*3
                    stack.pop();
                    x = (x + y) * 3;
                }
            }
        }

        // 출력
        if(cnt == 0) System.out.println(0);
        else System.out.println(cnt);

    }
}

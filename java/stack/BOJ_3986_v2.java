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
public class BOJ_3986_v2 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int goodCnt = 0;

        // 로직
        while(N-- > 0){
            String[] word = sc.next().split("");
            Deque<String> stack = new ArrayDeque<>();
            boolean goodWord = true, flagA = true, flagB = true;

            for(String s : word){
                if(s.equals("A") && flagA){ // stack에 A의 여는 괄호가 없는 경우 여는 괄호를 삽입
                    stack.push(s);
                    flagA = false;
                }else if(s.equals("B") && flagB){
                    stack.push(s);
                    flagB = false;
                }else{ // stack에 여는 괄호가 있는 경우 닫는 괄호로 닫음
                    if(stack.isEmpty()){
                        goodWord = false;
                        break;
                    }

                    String popVal = stack.pop();
                    if(s.equals("A") && popVal.equals("B") || s.equals("B") && popVal.equals("A")){
                        // 다음 단어가 A일때, 닫는 괄호가 B라면 쌍이 안맞음 or 다음 단어가 B일때, 닫는 괄호가 A라면 쌍이 안맞음
                        goodWord = false;
                        break;
                    }else if(s.equals("A") && popVal.equals("A")){
                        flagA = true;
                    }else if(s.equals("B") && popVal.equals("B")){
                        flagB = true;
                    }
                }
            }

            if(!stack.isEmpty()) goodWord = false;
            if(goodWord) goodCnt++;
        }

        // 출력
        System.out.println(goodCnt);
    }
}

































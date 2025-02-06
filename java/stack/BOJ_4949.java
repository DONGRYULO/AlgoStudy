package stack;

/*
    case)
    () -> O
    (} -> X
    ) {} -> X
    (} ) -> X
    {(} ) -> X

    1. 여는 괄호일 경우 스택에 삽입
    2. 닫는 괄호인 경우
    2.1. 스택이 비어있으면(여는 괄호가 없는 경우) 올바르지 않은 괄호 쌍
    2.2. 스택의 맨 위에 있는 괄호의 종류가 닫는 괄호의 종류와 일치하는지 체크
    - 일치하면, 스택의 맨 위에 있는 괄호를 pop 하고 다음 괄호를 찾기
    - 일치하지 않으면 올바르지 않는 괄호 쌍
    3. 온점이 하나만 있는게 아니라면 정답 출력
    - 스택에 값이 비어있으면 yes, 값이 있으면 no
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String[] input = sc.nextLine().split("");
            if(input[0].equals(".")) break; // 프로그램 종료

            Deque<String> stack = new ArrayDeque<>();
            boolean flag = true; // yes or no 여부 체크
            for(int i=0;i<input.length;i++){
                if(input[i].equals("(") || input[i].equals("[")){
                    stack.push(input[i]);
                }else if(input[i].equals(")") || input[i].equals("]")){
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    String peekVal = stack.peek();
                    if( (peekVal.equals("(") && input[i].equals(")")) || (peekVal.equals("[") && input[i].equals("]")) ){
                        stack.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }
            }

            if(flag && stack.isEmpty()){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }

    }
}

































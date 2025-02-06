package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_2504_v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");

        int cnt = 0; // 출력 변수
        int num = 1; // 곱해질 값

        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<input.length;i++){
            if(input[i].equals("(")){
                stack.push(input[i]);
                num *= 2;
            }else if(input[i].equals("[")){
                stack.push(input[i]);
                num *= 3;
            }else if(input[i].equals(")")){
                if(stack.isEmpty() || stack.peek().equals("[")){ // 올바르지 못한 괄호쌍
                    cnt = 0;
                    break;
                }

                // 닫는 괄호가 나오면 이전까지 나왔던 여는 괄호에 대해서 전체합을 계산
                // 단, 닫는 괄호가 연속으로 나온 경우에는 최초로 나온 닫는 괄호에 대해서 한번만 계산한다.

                // ex) 여러 개의 괄호가 섞인 케이스 : ( (4) [6] ) = 10
                // 2 (2 + 3) = 4를 먼저 계산하고 6을 더해줌
                // cnt = 4, num = 2
                // cnt = 4 + 6(num)
                stack.pop();
                if(input[i-1].equals("(")){
                    cnt = cnt + num;
                }
                num = num / 2;
            }else if(input[i].equals("]")){
                if(stack.isEmpty() || stack.peek().equals("(")){ // 올바르지 못한 괄호쌍
                    cnt = 0;
                    break;
                }

                stack.pop();
                if(input[i-1].equals("[")){
                    cnt = cnt + num;
                }
                num = num / 3;
            }
        }

        // 출력
        if(!stack.isEmpty()) cnt = 0;
        System.out.println(cnt);
    }
}

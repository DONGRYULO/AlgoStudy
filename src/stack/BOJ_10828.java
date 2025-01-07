package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            String input = sc.next();

            if(input.equals("push")){
                int value = sc.nextInt();
                stack.push(value);
            }else if(input.equals("pop")){
                int value = -1;
                if(!stack.isEmpty()){
                    value = stack.pop();
                }
                System.out.println(value);
            }else if(input.equals("size")){
                System.out.println(stack.size());
            }else if (input.equals("empty")){
                int value = 1;
                if(!stack.isEmpty()){
                    value = 0;
                }
                System.out.println(value);
            }else if (input.equals("top")){
                int value = -1;
                if(!stack.isEmpty()){
                    value = stack.peek();
                }
                System.out.println(value);
            }
        }
    }
}

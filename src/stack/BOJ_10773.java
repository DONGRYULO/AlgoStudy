package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class BOJ_10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<K;i++){
            int num = sc.nextInt();
            if(num == 0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }

        // 출력
        Iterator<Integer> iterator = stack.iterator();

        int sum = 0;
        while(iterator.hasNext()){
            sum += iterator.next();
        }
        System.out.println(sum);
    }
}

package queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            String command = sc.next();
            if(command.equals("push")){
                int offerValue = sc.nextInt();
                queue.offer(offerValue);
            }else if(command.equals("pop")){
                int popValue = -1;
                if(!queue.isEmpty()){
                    popValue = queue.poll();
                }
                System.out.println(popValue);
            }else if(command.equals("size")){
                System.out.println(queue.size());
            }else if(command.equals("empty")){
                int emptyValue = 1;
                if(!queue.isEmpty()){
                    emptyValue = 0;
                }
                System.out.println(emptyValue);
            }else if(command.equals("front")){
                int frontValue = -1;
                if(!queue.isEmpty()){
                    frontValue = queue.peekFirst();
                }
                System.out.println(frontValue);
            }else if(command.equals("back")){
                int backValue = -1;
                if(!queue.isEmpty()){
                    backValue = queue.peekLast();
                }
                System.out.println(backValue);
            }
        }
    }
}

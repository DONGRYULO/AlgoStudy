package deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            String command = sc.next();
            if(command.equals("push_front")){
                int value = sc.nextInt();
                deque.offerFirst(value);
            }else if(command.equals("push_back")){
                int value = sc.nextInt();
                deque.offerLast(value);
            }else if(command.equals("pop_front")){
                int value = -1;
                if(!deque.isEmpty()){
                    value = deque.pollFirst();
                }
                System.out.println(value);
            }else if(command.equals("pop_back")){
                int value = -1;
                if(!deque.isEmpty()){
                    value = deque.pollLast();
                }
                System.out.println(value);
            }else if(command.equals("size")){
                System.out.println(deque.size());
            }else if(command.equals("empty")){
                int value = 1;
                if(!deque.isEmpty()){
                    value = 0;
                }
                System.out.println(value);
            }else if(command.equals("front")){
                int value = -1;
                if(!deque.isEmpty()){
                    value = deque.peekFirst();
                }
                System.out.println(value);
            }else if(command.equals("back")){
                int value = -1;
                if(!deque.isEmpty()){
                    value = deque.peekLast();
                }
                System.out.println(value);
            }
        }
    }
}

package queue;

/*
    큐 성질)
    1. 원소의 추가 O(1)
    2. 원소의 제거 O(1) 단, 인덱스를 가지고 원소에 접근하는 기능이 없기 때문에 특정 원소를 콕 찝어서 제거하지는 못함
    3. 제일 앞/뒤가 아닌 나머지 원소들의 검색, 수정, 삭제가 원칙적으로 불가능

    큐를 배열로 구현시에는 원소가 삭제될 때 마다 head값이 증가하면서 앞쪽에 쓸모없는 공간이 계속 생기기 때문에 공간이 많음에도 불구하고 원소를 추가할 수 없는 상황이 생길 수 있음
    실무에서 큐를 구현해야 한다면 원형 큐를 만들어서 앞쪽의 공간을 효율적으로 사용할 수 있음
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class queueTest {
    static final int MX = 100005;
    int[] data = new int[MX];
    // 원소가 추가되는 곳(tail, rear), 원소가 제거되는 곳(head, front)
    // 배열의 꼬리부분으로 데이터가 들어와서 제거 될 때는 맨 앞쪽에서 삭제되는 방식으로 이해(FIFO)
    int head = 0, tail = 0;

    public static void main(String[] args) {
        // 직접 구현한 큐
        queueTest test = new queueTest();
        test.push(10);
        test.push(20);
        test.push(30);

        test.queueList();
        test.pop();
        test.queueList();
        System.out.println(test.size());

        // 큐 라이브러리
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
    }

    void push(int x){
        data[tail++] = x;
    }

    void pop(){
        head++;
    }

    int size(){
        return tail - head;
    }

    int front(){
        return data[head];
    }

    int back(){
        return data[tail - 1];
    }

    void queueList(){
        System.out.print("[");
        for(int i=head;i<tail;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println("]");
    }
}

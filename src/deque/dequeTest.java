package deque;

public class dequeTest {
    static final int MX = 10;
    int[] data = new int[2*MX+1];
    int head = MX, tail = MX;

    public static void main(String[] args) {
        // [][][H,T][][]
        // [][1(h)][2][T][]

        dequeTest deque = new dequeTest();
        deque.push_front(10);
        deque.push_back(50);
        deque.push_front(24);
    }

    void push_front(int x){
        // 큐에서 head의 위치와 동일하게 생각
        data[--head] = x;
    }

    void push_back(int x){
        // tail을 해당 위치에 삽입하고 인덱스를 한 칸 이동
        data[tail++] = x;
    }

    void pop_front(){
        head++;
    }

    void pop_back(){
        tail--;
    }

    int front(){
        return data[head];
    }

    int back(){
        return data[tail - 1];
    }

    int size(){
        return tail - head;
    }

    void dequeList(){
        for(int i = head;i<tail;i++){
            System.out.print(data[i] + " ");
        }
    }
}

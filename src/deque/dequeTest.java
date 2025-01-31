package deque;

public class dequeTest {
    static final int MX = 10;
    // 어떤 정수든 2를 곱하면 짝수가 된다.(단, 0은 제외)
    // 왜냐하면 2의 배수가 되기 때문에 짝수가 됨
    // 3 -> 3*2, 2 -> 2*2
    int[] data = new int[2*MX+1];
    int head = MX, tail = MX;

    public static void main(String[] args) {

        // [][][H,T][][] mx:2(data:5), h:2, t:2
        // [][1(h)][T][][] push_front -> --h:1
        // [][][H,T][][] pop_front -> h++:2

        // [][][H,2(T)][][] push_back -> t:3(tail의 실제값은 인덱스2에 있음)
        // [][][H,2(T)][][] pop_back -> t--:2

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


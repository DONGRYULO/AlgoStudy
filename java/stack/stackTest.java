package stack;

/*
    배열로 스택 구현)
*/

import java.util.*;

public class stackTest {
    static int MX = 100005;
    int[] data = new int[MX]; // 원소를 담을 배열
    int pos = 0; // 원소가 삽입될 때, 가리키는 곳(원소의 개수 or 스택의 길이)

    public static void main(String[] args) {
        stackTest st = new stackTest();
        st.push(10);
        st.push(20);
        st.push(30);

        st.stackList();

        // 자바의 Stack 클래스는 내부에서 Vector라는 자료구조를 사용하는데, 이 자료 구조는 자바 1.0에 개발되었기 때문에 사용되지 않고 하위호환을 위해 존재함
        // 그러므로 스택을 자료구조를 사용할 때는 Deque 클래스를 이용하자
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

    void push(int x){
        data[pos++] = x;
    }

    void pop(){
        pos--;
    }

    int top(){
        return data[pos-1];
    }

    boolean isEmpty(){
        return pos == 0;
    }

    void stackList(){
        System.out.print("[");
        for(int i=0;i<pos;i++){
            if(i == pos-1) System.out.print(data[i]);
            else System.out.print(data[i] + ", ");
        }
        System.out.println("]");
    }
}

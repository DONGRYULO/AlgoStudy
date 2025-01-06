package linkedList;

/*
    1회차)
    걸린시간 : 2시간
    풀이방법 참고 : O
    이해 여부 : O
*/

import java.util.*;
import java.util.LinkedList;
import java.util.Scanner;

/*
    LinkedList의 listIterator 메소드 뜯어보기

    1. listIterator(test.size())
    링크드 리스트에 [a,b] 2개의 노드가 있을 때, 메소드 호출시 파라미터에 리스트의 size를 넣으면
    last Node는 b를 가리키고 있으며 다음 node는 null이고 인덱스는 2를 뜻함
    파라미터에 인덱스 0을 넣으면 last Node는 a를 가리키고 있으며 다음 node는 a이고 인덱스는 0를 뜻함

    주의 할 점)
    private Node<E> lastReturned; (변수명만 보고 어떤 동작을 하는지 유추하기가 어려움)
    listIterator를 호출하면 lastReturned은 null로 초기 세팅이 잡힘 
    링크드 리스트에 있는 마지막 노드를 뜻하는 것이 아니라 여기서 말하는 last는 가장 최근에 반환된 노드를 의미함
    정확히 말하면 ListIterator의 next() 또는 previous() 메서드에 의해 마지막으로 반환된 노드를 뜻함
*/

public class BOJ_1406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기 문자열 입력
        String input = sc.next();
        LinkedList<Character> list = new LinkedList<>();

        for (char c : input.toCharArray()) {
            list.add(c);
        }

        // 커서를 리스트 끝으로 초기화
        // [a, b, | -> X] size(2), next = null, nextIndex = 2
        // cursor는 b의 오른쪽에 위치하고 코드상으로는 b를 가리키고 있지 않음
        ListIterator<Character> cursor = list.listIterator(list.size());

        int commandCnt = sc.nextInt(); // 명령어 개수 입력
        for (int i = 0; i < commandCnt; i++) {
            String command = sc.next();

            if (command.equals("L")) { // 커서를 왼쪽으로 이동
                if (cursor.hasPrevious()) {
                    // [a, b | -> X] -> [a, | -> b]
                    cursor.previous();
                }
            } else if (command.equals("D")) { // 커서를 오른쪽으로 이동
                if (cursor.hasNext()) {
                    cursor.next();
                }
            } else if (command.equals("B")) { // 커서 왼쪽 문자 삭제
                if (cursor.hasPrevious()) {
                    // [a, b |] -> [a |]
                    cursor.previous();
                    cursor.remove();
                }
            } else if (command.equals("P")) { // 커서 왼쪽에 문자 추가
                char addValue = sc.next().charAt(0);
                cursor.add(addValue);
            }
        }

        // 결과 출력
        StringBuilder result = new StringBuilder();
        for (char c : list) {
            result.append(c);
        }
        System.out.println(result);
    }
}


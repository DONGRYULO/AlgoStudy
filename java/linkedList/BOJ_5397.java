package linkedList;

/*
    1회차)
    걸린시간 : 1시간
    풀이방법 참고 : O
    이해 여부 : X
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_5397 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        // 입력
        /*
            "<<BP<A>>Cd-"
             <(왼쪽으로 커서 한 칸 이동), >(오른쪽으로 커서 한 칸 이동)
             백스페이스 -> "-"(커서의 앞에 글자가 존재하면 지움)

             문제에서 최초의 커서 위치가 어디에 있는지 안 알려줌

             링크드 리스트 구조로 생각하기)
             최초 링크 : []
             1. < <
             prev() 이전 노드 이동 -> Node가 없으니까 이동 X
             2. BP
             [B] -> [P] -> (cursor)
             3. <
             [B] -> [P(cursor)]
             4. A
             [B] -> [A] -> [P(cursor)]
             5. > >
             [B] -> [A] -> [P] -> cursor
             6. Cd
             [B] -> [A] -> [P] -> [C] -> [d] -> cursor
             7. -
             [B] -> [A] -> [P] -> [C] -> cursor
        */


        for(int i = 0; i < cnt; i++){
            // 입력
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            String[] inputArr = input.split("");

            // 로직
            LinkedList<String> list = new LinkedList<>();
            ListIterator<String> link = list.listIterator(0);
            for(int j = 0; j < inputArr.length; j++){
                if(inputArr[j].equals("<")){
                    if(link.hasPrevious()){
                        link.previous();
                    }
                }else if(inputArr[j].equals(">")){
                    if(link.hasNext()){
                        link.next();
                    }
                }else if(inputArr[j].equals("-")){
                    if(link.hasPrevious()){
                        link.previous();
                        link.remove();
                    }
                }else{
                    link.add(inputArr[j]);
                }
            }

            // 결과 출력
            for(String ouput : list){
                System.out.print(ouput);
            }
            System.out.println();
        }
    }
}




































package linkedList;

/*
    1회차)
    걸린시간 : 9:30(시작) ~ 11:20(종료)
    풀이방법 참고 : O
    이해 여부 : O
*/

/*
    N명의 사람이 주어짐 순서대로 K번째 사람을 제거

    ex) N(7)명의 사람이 주어지고 K(3)번째 사람을 제거
    1, 2, 3[remove], 4, 5, 6, 7  -> 2번째 인덱스 제거
    1, 2, 4, 5, 6[remove], 7     -> 4(5-1) 인덱스 제거    -> size(6) > index(4) 리스트의 길이가 제거할 인덱스보다 클 경우만 제거 가능
    1, 2[r], 4, 5, 7             -> 6(7-1)번째 인덱스 제거 -> 제거할 인덱스가 리스트의 길이보다 클 경우 size(5) < index(6) -> index%size = 1(나머지)
    1, 4, 5, 7[r]                -> 3(4-1)번째 인덱스 제거
    1, 4, 5[r]                   -> 5(6-1)번째 인덱스 제거 -> 제거할 인덱스가 리스트의 길이보다 클 경우 size(3) < index(5) -> index%size = 2(나머지)
    1[r], 4                      -> 4(5-1)번째 인덱스 제거 -> 제거할 인덱스가 리스트의 길이보다 클 경우 size(2) < index(4) -> index%size = 0(나머지)
    4[r]                         -> 2(3-1)번째 인덱스 제거 -> 제거할 인덱스가 리스트의 길이보다 클 경우 size(1) < index(2) -> index%size = 0(나머지)

    Q.남아있는 원소의 개수가 K미만 일 때, 하나씩 순회하지 않고 빠르게 제거하는 방법이 있을까?

    제거된 원소의 그 다음 위치를 시작으로 K번째 원소를 N명의 사람이 모두 없어질 때까지 계속 제거

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1158 {

    public static void main(String[] args) {

        // 1. N, K를 입력받고 리스트에 차례대로 1~N까지 값을 넣음
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=N;i++){
            list.add(i);
        }

        // 2. 리스트가 빌 때까지 K번째에 있는 사람을 제거 후 출력
        ArrayList<Integer> output = new ArrayList<>();
        int removeIndex = 0;

        while(!list.isEmpty()){
            removeIndex += K - 1;
            if(list.size() <= removeIndex){
                removeIndex = removeIndex % list.size();
            }

            output.add(list.remove(removeIndex));
        }

        // 3. 출력
        System.out.print("<");
        for (int i = 0; i < output.size() ; i++) {
            if(i == output.size() - 1){
                System.out.print(output.get(i));
            }else{
                System.out.print(output.get(i) + ", ");
            }
        }
        System.out.print(">");

    }
}



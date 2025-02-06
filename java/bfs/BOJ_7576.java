package bfs;

/*
    <문제이해>
    값을 입력받을 때부터 익은 토마토를 큐에 넣어두고 동시에 큐에서 꺼내기
    주변에 익지 않은 토마토가 익을 때마다 기존 익은 토마토의 + 1을 해서 최소 날짜 계산

    큐에서 모든 값을 꺼내고 난 이후에 상자를 순회하면서 익지 않은 토마토가 있는지 체크 -> O(n*m)
    모두 익었으면 맨 마지막에 나온 큐에 값에 -1 를 해서 출력
*/

import java.util.*;

public class BOJ_7576 {
    public static void main(String[] args) {
         // 입력
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 가로(열)
        int n = sc.nextInt(); // 세로(행)
        int[][] box = new int[n][m];
        Deque<int[]> q;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1){
                    q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                }
            }
        }

        // 로직


    }
}

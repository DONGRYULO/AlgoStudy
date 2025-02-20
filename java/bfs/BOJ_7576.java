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
        Deque<int[]> q = new ArrayDeque<>();

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
            }
        }

        // 로직
        int minDate = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int dir=0;dir<4;dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽 or 익은 토마토 체크
                if(box[nx][ny] == -1 || box[nx][ny] >= 1) continue;
                box[nx][ny] = box[cur[0]][cur[1]] + 1; // 익어가기 위해 전파된 토마토 거리
                minDate = box[nx][ny] - 1;
                q.offer(new int[]{nx, ny});
            }
        }

        // 모두 익지 못하는 상황인지 체크
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(minDate);

    }
}
























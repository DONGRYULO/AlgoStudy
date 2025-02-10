package bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_7576_v2 {
    public static void main(String[] args) {
         // 입력
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 가로(열)
        int n = sc.nextInt(); // 세로(행)
        int[][] box = new int[n][m];
        int[][] dist = new int[n][m]; // 최소일수를 구하는 용도
        Deque<int[]> q = new ArrayDeque<>();

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1){
                    q.offer(new int[]{i, j});
                }else if(box[i][j] == 0){
                    dist[i][j] = -1; // 익지 않은 토마토 -1로 세팅
                }
            }
        }

        // 로직
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int dir=0;dir<4;dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽은 0으로 or 익은 토마토는 0 이상으로 체크
                if(dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1; // 익어가기 위해 전파된 토마토 거리
                q.offer(new int[]{nx, ny});
            }
        }

        // 모두 익지 못하는 상황인지 체크
        int minDate = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dist[i][j] == -1){
                    System.out.println(-1);
                    return;
                }
                if(dist[i][j] > minDate){
                    minDate = dist[i][j];
                }
            }
        }

        System.out.println(minDate);

    }
}
























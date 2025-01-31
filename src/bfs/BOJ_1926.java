package bfs;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_1926 {
    public static void main(String[] args) {
        // 1.입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 세로(행)
        int m = sc.nextInt(); // 가로(열)

        int[][] board = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        int[] dx = {-1,1,0,0}; // 행
        int[] dy = {0,0,-1,1}; // 열

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = sc.nextInt();
            }
        }

        // 2.로직
        int cnt = 0; // 그림 개수
        int maxSize = 0; // 그림 넓이

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 1 && !vis[i][j]) {
                    cnt++;
                    int size = 0;
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;

                    while(!q.isEmpty()){
                        int[] pair = q.poll();
                        size++;

                        for(int dir=0;dir<4;dir++){
                            int nx = pair[0] + dx[dir];
                            int ny = pair[1] + dy[dir];
                            // 범위 여부
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            // 방문, 비인가 여부
                            if(vis[nx][ny] || board[nx][ny] == 0) continue;
                            q.offer(new int[]{nx, ny});
                            vis[nx][ny] = true;
                        }
                    }
                    // 가장 큰 그림의 넓이라면 세팅
                    if(size > maxSize) maxSize = size;
                }
            }
        }

        // 3.출력
        System.out.println(cnt);
        System.out.println(maxSize);


    }
}


























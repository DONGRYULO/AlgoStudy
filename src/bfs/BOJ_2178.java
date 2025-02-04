package bfs;

/*
    1회차)
    걸린시간 : 30분
    풀이방법 참고 : X
    이해 여부 : O
*/

/*
    문제풀이)
    board를 (1,1)을 1로 시작해서 인접한 칸이 있으면 +1을 증가시키는 방식
    단, 이미 방문했거나 인접한 칸이 0이라면 증가 X
    최종적으로 (n,m)에 위치에 있는 값을 출력
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_2178 {
    public static void main(String[] args) {

        // 1.입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행
        int m = sc.nextInt(); // 열

        int[][] board = new int[n][m];
        int[][] dis = new int[n][m]; // 방문여부를 검사하지 않고 거리를 체크하는 방식으로 해도 됨

        for(int i = 0; i < n; i++){
            String[] line = sc.next().split("");
            for(int j = 0; j < line.length; j++){
                board[i][j] = Integer.parseInt(line[j]);
                dis[i][j] = -1;
            }
        }

        // 2.로직
        // boolean[][] vis = new boolean[n][m];
        int[] dx = {-1,1,0,0}; // 행
        int[] dy = {0,0,-1,1}; // 열
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        // vis[0][0] = true;
        dis[0][0] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int dir=0;dir<4;dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                // 범위 체크
                if(nx < 0 || nx >=n || ny < 0 || ny >= m) continue;
                // 방문, 올바르지 않는 길 체크
                // if(vis[nx][ny] || board[nx][ny] == 0) continue;
                if(dis[nx][ny] >= 0 || board[nx][ny] == 0) continue;
                q.offer(new int[]{nx, ny});
                dis[nx][ny] = dis[cur[0]][cur[1]] + 1;
                // vis[nx][ny] = true;
            }
        }

        // 3.출력
        System.out.println(board[n-1][m-1] + 1);

    }
}























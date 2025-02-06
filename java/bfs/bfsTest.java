package bfs;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class bfsTest {

    static int[][] board = {
            {1,1,1,0,1,0,0,0,0,0},
            {1,0,0,0,1,0,0,0,0,0},
            {1,1,1,0,1,0,0,0,0,0},
            {1,1,0,0,1,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0} }; // 1이 파란 칸, 0이 빨간 칸에 대응

    static boolean[][] vis = new boolean[board.length][board[0].length]; // 방문여부
    static int n = 7, m = 10; // 행, 열
    // 상하좌우
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {

        // 좌표를 넣을 쌍
        Deque<Pair> q = new ArrayDeque<>();
        q.push(new Pair(0, 0));
        vis[0][0] = true;

        while(!q.isEmpty()) {
            Pair pair = q.pop();

            for(int dir=0;dir<4;dir++){
                int nx = pair.getX() + dx[dir];
                int ny = pair.getY() + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(vis[nx][ny] || board[nx][ny] != 1) continue;
                vis[nx][ny] = true;
                q.push(new Pair(nx, ny));
            }
        }

        // Pair 클래스를 만들지 않고 배열을 사용해도 가능
        // 0번째 인덱스는 x좌표, 1번째 인덱스는 y좌표인게 명시적으로 보이지 않는다는 단점이 있음
        Deque<int[]> q1 = new ArrayDeque<>();
        q1.push(new int[]{0 , 0});

        while(!q1.isEmpty()) {
            int[] pair = q1.pop();

            for(int dir=0;dir<4;dir++){
                int nx = pair[0] + dx[dir];
                int ny = pair[1] + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(vis[nx][ny] || board[nx][ny] != 1) continue;
                vis[nx][ny] = true;
                q1.push(new int[]{nx, ny});
            }
        }
    }
}























package 이상명;

import java.io.*;
import java.util.*;

public class BOJ_3055_탈출 {

    static int R, C;
    static int[] d, s;
    static int[][] move = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static char[][] map;
    static int[][] water;
    static int dp[][];
    static int count;
    static Queue<Pos> q;
    static boolean foundanswer;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("SDS/0718/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        map = new char[R][C];
        s = new int[2];
        d = new int[2];
        dp = new int[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'S') {
                    s[0] = i;
                    s[1] = j;
                } else if (map[i][j] == '*') {
                    q.offer(new Pos(j, i, '*'));
                }
            }
        }
        q.offer(new Pos(s[1], s[0], 'S'));
        dp[s[0]][s[1]] = 0;
        bfs();
        if (!foundanswer) {
            System.out.println("KAKTUS");
        }
    }

    static void bfs() {
        while(!q.isEmpty()) {
            //1. 큐에서 꺼내옴 -> *, S, ., D
            Pos temp = q.poll();
            //2. 목적지인가? -> D
            if (temp.type == 'D') {
                foundanswer = true;
                System.out.println(dp[temp.yPos][temp.xPos]);
                break;
            }
            //3. 연결된 곳을 순회 -> 상하좌우
            for (int i = 0; i < 4; i++) {
                int tx = temp.xPos + move[i][0];
                int ty = temp.yPos + move[i][1];
                //4. 갈 수 있는가? -> map 안에 들어오는가 (공통), . or D or 방문하지 않은곳 (고슴도치), . (물)
                if (check(tx, ty)) {
                    if(temp.type == 'S' || temp.type == '.') {
                        if ((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) {
                            //5. 체크인 -> dp[][] = 이동거리 (고슴도치), map[][] = * (물)
                            dp[ty][tx] = dp[temp.yPos][temp.xPos] + 1;
                            //6. 큐에 넣음
                            q.add(new Pos(tx, ty, map[ty][tx]));
                        }
                    } else if (temp.type == '*') {
                        if (map[ty][tx] == '.' || map[ty][tx] == 'S') {
                            map[ty][tx] = '*';
                            q.add(new Pos(tx, ty, '*'));
                        }
                    }
                }
            }
        }
    }

    static boolean check(int xPos, int yPos) { return xPos < C && yPos >= 0 && xPos >= 0 && yPos < R; }

    static class Pos {
        private int xPos;
        private int yPos;
        private char type;

        Pos(int xPos, int yPos, char type) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.type = type;
        }
    }
}

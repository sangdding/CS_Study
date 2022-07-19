package 이상명;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1039_교환 {

    static int N, K;
    static Queue<Swap> queue;
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("SDS/0718/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        visited = new boolean[1000001][K+1];
        queue.add(new Swap(N, 0));
        visited[N][0] = true;
        result = -1;
        while (!queue.isEmpty()) {
//          1. 큐에서 꺼내옴
            Swap temp = queue.poll();
//          2. 목적지인가? => count == K
            if (temp.cnt == K) {
                result = Math.max(result, temp.num);
                continue;
            }
            int len = String.valueOf(temp.num).length();
//          3. 연결된 곳 순회 => N.length 까지
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int next = swap(temp.num, i, j);
//                  4. 갈 수 있는가? => ??
                    if (next != -1 && !visited[next][temp.cnt + 1]) {
//                      5. 체크인
                        visited[next][temp.cnt + 1] = true;
//                      6. 큐에 넣음
                        queue.add(new Swap(next, temp.cnt + 1));
                    }
                }
            }
        }
        System.out.println(result);
    }

    static int swap(int num, int i, int j) {
        char[] n = String.valueOf(num).toCharArray();
        if (i == 0 && n[j] == '0') {
            return -1;
        }
        char tmp;
        tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;

        return Integer.parseInt(new String(n));
    }

    static class Swap {
        int num;
        int cnt;

        Swap(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
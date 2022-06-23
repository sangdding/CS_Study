import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9576_책나눠주기 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Point[] points = new Point[M + 1];
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                points[i] = new Point(a, b);
            }

            Arrays.sort(points, 1, M + 1, (p1, p2) -> (p1.y == p2.y) ? p1.x - p2.x : p1.y - p2.y);

            int ans = 0;
            boolean[] check = new boolean[N + 1];
            for (int i = 1; i <= M; i++) {
                int a = points[i].x;
                int b = points[i].y;

                for (int j = a; j <= b; j++) {
                    if (!check[j]) {
                        check[j] = true;
                        ans++;
                        break;
                    }
                }
            }
            sb.append(ans + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
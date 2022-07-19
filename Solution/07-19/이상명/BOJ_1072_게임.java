package 이상명;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072_게임 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("SDS/0719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = 100 * Y / X;
        long s = 0, e = X, result = -1;
        while (true) {
            long mid = (s + e) / 2;
            long score = (Y + mid) * 100 / (X + mid);
            if (score > Z) {
                e = mid - 1;
                result = mid;
            } else if (score == Z) {
                s = mid + 1;
            }
            if (s > e) break;
        }
        System.out.println(result);
    }
}

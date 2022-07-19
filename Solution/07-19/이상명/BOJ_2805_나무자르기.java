package 이상명;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("SDS/0719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trees = new int[N+1];
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long s = 0, e = max, sum = 0, result = 0;
        long m;
        while (true) {
            m = (s + e) / 2;
            sum = getSum(m);
            if (sum > M) {
                result = m;
                s = m + 1;
            } else if (sum == M) {
                result = m;
                break;
            } else {
                e = m - 1;
            }
            if (s > e) {
                break;
            }
        }

        System.out.println(result);
    }

    static long getSum(long m) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > m) {
                sum += tree - m;
            }
        }
        return sum;
    }
}

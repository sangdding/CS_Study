package 이상명;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {

    static int N, S, sum, h, l, min;
    static int[] array;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("SDS/0719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[N + 1];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        min = N+1;
        sum = array[0];
        while (h < N) {
            if (sum >= S) {
                if (h - l + 1 < min) {
                    min = h - l + 1;
                }
                sum -= array[l++];
            } else {
                sum += array[++h];
            }
        }
        if (min == N + 1) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}

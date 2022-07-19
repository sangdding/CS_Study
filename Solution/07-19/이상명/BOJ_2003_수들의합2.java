package 이상명;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {

    static int N, M, h, l;
    static int[] array;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("SDS/0719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int sum = array[0];
        int count = 0;
        while (h < N) {
            if (sum < M) {
                sum += array[++h];
            } else if (sum > M){
                sum -= array[l++];
            } else {
                count++;
                sum -= array[l++];
            }
        }

        System.out.println(count);
    }
}

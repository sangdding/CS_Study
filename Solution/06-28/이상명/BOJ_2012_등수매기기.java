import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2012_등수매기기 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] grade;
    public static long result;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        grade = new int[N];

        for (int i = 0; i < N; i++) {
            grade[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(grade);
        result = 0;
        for (int i = 0; i < N; i++) {
            result += Math.abs(grade[i] - (i+1));
        }
        System.out.println(result);
    }
}

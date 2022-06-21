import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_9237_이장님초대 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] t = new Integer[N];
        int day = 1;
        int max = 0;
        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < temp.length; i++) {
            t[i] = Integer.parseInt(temp[i]) + 1;
        }
        Arrays.sort(t, Collections.reverseOrder());

        for (int i = 0; i < temp.length; i++) {
            if(max < t[i]) {
                max = t[i];
            }
            max--;
            day++;
        }
        System.out.print(day + max);
    }
}

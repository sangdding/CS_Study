package 이상명;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2143_두배열의합 {

    static long T, count;
    static int n, m, indexA, indexB;
    static long temp;
    static long[] A, B;
    static List<Long> aSum, bSum;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("SDS/0719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(br.readLine());

        n = Integer.parseInt(br.readLine());
        A = new long[n];
        aSum = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            A[j] = Long.parseLong(st.nextToken());
        }
        for (int j = 0; j < n; j++) {
            temp = A[j];
            aSum.add(temp);
            for (int k = j+1; k < n; k++) {
                temp += A[k];
                aSum.add(temp);
            }
        }
        Collections.sort(aSum);
        m = Integer.parseInt(br.readLine());
        B = new long[m];
        bSum = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            B[j] = Long.parseLong(st.nextToken());
        }
        for (int j = 0; j < m; j++) {
            temp = B[j];
            bSum.add(temp);
            for (int k = j+1; k < m; k++) {
                temp += B[k];
                bSum.add(temp);
            }
        }
        Collections.sort(bSum, Collections.reverseOrder());

        while (true) {
            long currentA = aSum.get(indexA);
            long currentB = bSum.get(indexB);
            temp = aSum.get(indexA) + bSum.get(indexB);
            //범위 조건
            if (temp > T) {
                indexB++;
            } else if (temp == T) {
                long countA = 0;
                long countB = 0;
                while (indexA < aSum.size() && aSum.get(indexA) == currentA) {
                    countA++;
                    indexA++;
                }
                while (indexB < bSum.size() && bSum.get(indexB) == currentB) {
                    countB++;
                    indexB++;
                }
                count += countA * countB;
            } else {
                indexA++;
            }
            //탈출 조건
            if(indexA == aSum.size() || indexB == bSum.size()) break;
        }
        System.out.println(count);
    }
}

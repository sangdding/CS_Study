package 이상명;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {

    static int L, C;
    static String[] words;
    static boolean[] visited;
    static int length;
    static int count;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("SDS/0718/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        words= new String[C];
        String line=br.readLine();
        String [] splitline=line.split(" ");
        visited = new boolean[C];
        for (int i = 0; i < C; i++) {
            words[i] = splitline[i];
        }
        Arrays.sort(words);
        for (int i = 0; i < C; i++) {
            dfs(i);
        }
    }

    static void dfs(int index) {
//      1. 체크인
        visited[index] = true;
        length++;
//      2. 목적지인가?
        if (length == L) {
            // 계산
            String temp = check();
            if (temp != null) {
                System.out.println(temp);
            }
        } else {
//      3. 연결된 곳을 순회
            for (int i = index + 1; i < C; i++) {
//          4. 갈 수 있는가? : 방문 여부
                if (!visited[i]) {
//              5. 간다 : dfs()
                    dfs(i);
                }
            }
        }
//      6. 체크아웃
        visited[index] = false;
        length--;
    }

    static String check() {
        String temp = "";
        count = 0;
        for (int i = 0; i < C; i++) {
            if (visited[i]) {
                if(words[i].equals("a") || words[i].equals("e") || words[i].equals("i") || words[i].equals("o") || words[i].equals("u")) {
                    count++;
                }
                temp = temp.concat(words[i]);
            }
        }
        if(count >= 1 && temp.length() - count >= 2) return temp;
        return null;
    }
}
package 이상명;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062_가르침 {

    static int N, K;
    static String[] words;
    static boolean[] visited;
    static int selectedCount;
    static int max = 0;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("SDS/0718/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("[antic]", "");
        }
        selectedCount = 5;
        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        System.out.print(max);
    }

    static void dfs(int index) {
//      1. 체크인
        visited[index] = true;
        selectedCount++;
//      2. 목적지인가? : selectedCount == K => 읽을 수 있는 단어 개수 계산
        if (selectedCount == K) {
            // 계산
            int answer = 0;
            for (String word : words) {
                if(find(word)) answer++;
            }
            max = Math.max(max, answer);
        } else {
//      3. 연결된 곳을 순회 : index + 1 ~ 25
            for (int i = index+1; i <= 25; i++) {
//          4. 갈 수 있는가? : 방문 여부
                if (!visited[i]) {
//              5. 간다 : dfs()
                    dfs(i);
                }
            }
        }
//      6. 체크아웃
        visited[index] = false;
        selectedCount--;
    }

    static boolean find(String word) {
        for (int i = 0; i < word.length(); i++) {
            if(!visited[word.charAt(i)-97]) return false;
        }
        return true;
    }
}

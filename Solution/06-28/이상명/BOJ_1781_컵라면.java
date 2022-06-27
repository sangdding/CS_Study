import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1781_컵라면 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Question[] input;
    public static PriorityQueue<Integer> result;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        input = new Question[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            Question item = new Question(deadline, num);
            input[i] = item;
        }
        Arrays.parallelSort(input);
        result = new PriorityQueue<>();
        for (Question question : input) {
            int size = result.size();
            if (size < question.deadline) {
                result.offer(question.num);
            } else if(size == question.deadline){
                int peek = result.peek();
                if (peek < question.num) {
                    result.poll();
                    result.offer(question.num);
                }
            }
        }
        long answer = 0;
        while (!result.isEmpty()) {
            answer += result.poll();
        }
        System.out.println(answer);
    }
}

class Question implements Comparable<Question> {

    int deadline;
    int num;

    Question(int deadline, int num) {
        this.deadline = deadline;
        this.num = num;
    }

    @Override
    public int compareTo(Question o) {
        if (this.deadline < o.deadline) {
            return -1;
        } else if (this.deadline == o.deadline) {
            if (this.num > o.num) {
                return -1;
            } else if (this.num == o.num) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
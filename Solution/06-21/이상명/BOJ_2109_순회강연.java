import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2109_순회강연 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp = new String[2];
        PriorityQueue<Lecture> priorityQueue = new PriorityQueue<>();
        int result = 0;
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            Lecture item = new Lecture(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            if(maxDay < item.day) maxDay = item.day;
            priorityQueue.add(item);
        }

        boolean[] check = new boolean[maxDay+1];

        while (!priorityQueue.isEmpty()) {
            Lecture lecture = priorityQueue.poll();
            for (int i = lecture.day; i > 0; i--) {
                if(!check[i]) {
                    result += lecture.pay;
                    check[i] = true;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    static class Lecture implements Comparable<Lecture> {

        int pay;
        int day;
        Lecture(int p, int d) {
            this.day = d;
            this.pay = p;
        }


        @Override
        public int compareTo(Lecture o) {
            if(o.pay > this.pay) {
                return 1;
            } else if (o.pay == this.pay) {
                if (o.day < this.day) {
                    return 1;
                }
            }
            return -1;
        }
    }
}

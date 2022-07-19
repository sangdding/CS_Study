package 이상명;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1713_후보추천하기 {

    static int N;
    static int recommend;
    static Student[] nominees;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("SDS/0719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        recommend = Integer.parseInt(br.readLine());

        nominees = new Student[101];

        List<Student> students = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < recommend; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 사진틀 : comparable
            // 최초 호출 시
            if (nominees[num] == null) {
                nominees[num] = new Student(num, 0, 0, false);
            }
            //사진 틀에 있는 경우
            if (nominees[num].isIn) {
                nominees[num].count++;
            } else {
                //해당 후보가 사진 틀에 없음
                //사진틀이 가득 찬 경우
                if (students.size() == N) {
                    //정렬, 지울 후보 선정, 제거
                    Collections.sort(students);
                    Student remove = students.remove(0);
                    remove.isIn = false;
                }
                //사진틀에 여유가 있는 경우
                nominees[num].count = 1;
                nominees[num].isIn = true;
                nominees[num].timeStamp = i;
                students.add(nominees[num]);
            }
        }
        // 출력 : comparator
        Collections.sort(students, Comparator.comparingInt(o -> o.num));
        for (Student student : students) {
            System.out.print(student.num + " ");
        }
    }

    private static class Student implements Comparable<Student>{
        int num;
        int count;
        int timeStamp;
        boolean isIn;

        public Student(int num, int count, int timeStamp, boolean isIn) {
            this.num = num;
            this.count = count;
            this.timeStamp = timeStamp;
            this.isIn = isIn;
        }
        //1. 추천수, 2. 시간
        @Override
        public int compareTo(Student o) {
            int comp = Integer.compare(count, o.count);
            if (comp == 0) {
                return Integer.compare(timeStamp, o.timeStamp);
            } else {
                return comp;
            }
        }
    }
}

public class Pro_체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] total = new int[n+1];
        for (int num : lost) {
            total[num] -= 1;
        }
        for (int num : reserve) {
            total[num] += 1;
        }
        for (int i = 1; i < n; i++) {
            if (total[i] == -1) {
                if (total[i - 1] == 1) {
                    total[i] = 0;
                    total[i-1] = 0;
                    answer++;
                } else if (total[i + 1] == 1) {
                    total[i] = 0;
                    total[i+1] = 0;
                    answer++;
                }
            } else {
                answer++;
            }
        }
        if (!(total[n] == -1 && total[n - 1] != 1)) {
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2,4}, new int[] {1,3,5}));
        System.out.println(solution(5, new int[]{2,4}, new int[] {3}));
        System.out.println(solution(3, new int[]{3}, new int[] {1}));
    }
}

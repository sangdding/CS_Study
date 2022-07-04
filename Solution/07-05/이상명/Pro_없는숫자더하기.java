public class Pro_없는숫자더하기 {

    public static int solution(int[] numbers) {
        int answer = -1;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return 45-sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
    }
}

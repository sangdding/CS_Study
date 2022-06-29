import java.util.Stack;

public class Pro_크레인인형뽑기 {

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] box = new Stack[board.length];
        for (int i = board.length-1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (box[j] == null) {
                    box[j] = new Stack<>();
                }
                if (board[i][j] != 0) {
                    box[j].push(board[i][j]);
                }
            }
        }
        Stack<Integer> result = new Stack<>();
        for (int move : moves) {
            int item;
            if (!box[move - 1].isEmpty()) {
                item = box[move - 1].pop();
                if (!result.isEmpty() && result.peek() == item) {
                    result.pop();
                    answer += 2;
                } else {
                    result.push(item);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }
}

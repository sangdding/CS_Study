public class Pro_키패드누르기 {

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keyPad = {{2, 1}, {2, 2}, {2, 3}, {2, 4}};
        Thumb thumb = new Thumb(1, 4, 3, 4);
        for (int number : numbers) {
            if(number == 0) {
                number = 10;
            }
            if (number == 1 || number == 4 || number == 7) {
                thumb.setPos(1, number/3+1, "L");
                answer += "L";
            } else if (number == 3 || number == 6 || number == 9) {
                thumb.setPos(3, number/3, "R");
                answer += "R";
            } else {
                String result = thumb.getDiff(keyPad[number/3][0], keyPad[number/3][1]);
                if (result == "equal") {
                    answer += hand;
                    thumb.setPos(keyPad[number/3][0], keyPad[number/3][1], hand);
                } else {
                    answer += result;
                    thumb.setPos(keyPad[number/3][0], keyPad[number/3][1], result);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "R";

        System.out.println(solution(inputs, hand));
    }
}

class Thumb {

    int leftXpos;
    int leftYpos;
    int rightXpos;
    int rightYpos;

    Thumb(int leftXpos, int leftYpos, int rightXpos, int rightYpos) {
        this.leftXpos = leftXpos;
        this.leftYpos = leftYpos;
        this.rightXpos = rightXpos;
        this.rightYpos = rightYpos;
    }

    public void setPos(int xPos, int yPos, String hand) {
        if (hand.equals("L")) {
            leftXpos = xPos;
            leftYpos = yPos;
        } else {
            rightXpos = xPos;
            rightYpos = yPos;
        }
    }

    public String getDiff(int destX, int destY) {
        int left = Math.abs(destX - leftXpos)+Math.abs(destY - leftYpos);
        int right = Math.abs(destX - rightXpos)+Math.abs(destY - rightYpos);
        if (left == right) {
            return "equal";
        } else {
            return left < right ? "L" : "R";
        }
    }
}

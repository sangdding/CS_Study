public class Pro_문자열압축 {

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int num = 1;
            String str = s.substring(0, i);
            StringBuilder result = new StringBuilder();
            for (int j = i; j <= s.length(); j += i) {
                String next = s.substring(j, Math.min(j + i, s.length()));
                if(str.equals(next)) num++;
                else{
                    result.append((num != 1 ? num : "") + str);
                    str = next;
                    num = 1;
                }
            }
            result.append(str);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
}

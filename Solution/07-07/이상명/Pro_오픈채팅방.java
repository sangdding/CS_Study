import java.util.HashMap;
import java.util.StringTokenizer;

public class Pro_오픈채팅방 {

    public static String[] solution(String[] record) {
        String[] answer;
        int num = record.length;
        StringTokenizer st;
        HashMap<String, String> nickName = new HashMap<>();
        String[] order = new String[record.length];
        String[] keys = new String[record.length];
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            order[i] = (st.nextToken());
            String key = st.nextToken();
            keys[i] = key;
            if (!nickName.containsKey(key)) {
                nickName.put(key, st.nextToken());
            } else if (order[i].equals("Enter") && nickName.containsKey(key)) {
                nickName.replace(key, st.nextToken());
            }
            if (order[i].equals("Change")) {
                nickName.replace(key, st.nextToken());
                num--;
            }
        }
        answer = new String[num];
        for (int i = 0, j = 0; i < order.length; i++) {
            if (order[i].equals("Enter")) {
                answer[j++] = nickName.get(keys[i]) + "님이 들어왔습니다.";
            } else if (order[i].equals("Leave")) {
                answer[j++] = nickName.get(keys[i]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] answer = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for (String o : answer) {
            System.out.println(o);
        }
    }
}

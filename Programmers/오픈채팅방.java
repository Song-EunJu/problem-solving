import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<String>(); // result를 담기 위한 list
        Map<String, String> map = new LinkedHashMap<String, String>(); // 아이디-닉네임 관리
        String [][] user = new String[record.length][3]; // record 배열 쪼개놓은 것

        // 1. 아이디 - 닉네임 관리
        for(int i=0;i<record.length;i++){
            user[i]=record[i].split(" "); // 한 줄씩 공백을 기준으로 찢음
            String behavior = user[i][0]; // 행동

            if(behavior.equals("Leave")) // leave 인 경우 닉네임이 바뀔 경우가 없으므로 아래 동작 안함
                continue;

            String id = user[i][1]; // id
            String nickname = user[i][2]; // nickname

            if(map.containsKey(id)){ // 해당 아이디가 keySet에 있으면
                map.remove(id); // 기존의 것을 지우고
                map.put(id, nickname); // 새로운 닉네임으로 바꾸어 업데이트
            }
            else{ // 해당 아이디(key)가 존재하지 않으면
                map.put(id, nickname); // 그냥 넣음
            }
        }

        // 2. 최신버전 id-username 을 가지고 String 값 만들기

        for(int i=0;i<record.length;i++){
            String behavior = user[i][0]; // 행동
            String id = user[i][1]; // 아이디

            if(behavior.equals("Enter")){
                list.add(map.get(id)+"님이 들어왔습니다.");
            }
            else if(behavior.equals("Leave")){ // Leave인 경우
                list.add(map.get(id)+"님이 나갔습니다.");
            }
            // change 인 경우는 위에서 id-username 에서 이미 최신버전으로 바꾸어놨기 때문에 할 작업이 없음
        }

        // 3. list에서 String[] 배열로 변환
        String answer[] = new String[list.size()];
        int i=0;
        for(String s : list){
            answer[i]=s;
            i++;
        }

        return answer;
    }
}
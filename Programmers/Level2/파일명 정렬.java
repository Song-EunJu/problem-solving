// compareToIgnoreCase - 대소문자 구분 없이 문자열 비교!!!
// 파일명에 포함된 숫자를 반영한 정렬 기능
// ssibal 때려치자
import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String answer[][] = new String[files.length][5];
        String result[] = new String[files.length];
        // 일단 HEAD / NUMBER / TAIL 로 구분
        // 숫자가 처음나오는 IDX 를 구하고, 거기서부터 FOR문을 돌면서 숫자가 아닌 위치가 나오는 첫번째 곳 FINISH 을 찾으면 
        // 그 가운데 부분이 숫자, IDX전까지가 HEAD, FINISH 부터가 TAIL

        for(int i=0;i<files.length;i++){
            String s = files[i];
            int numberStart = 0; // NUMBER의 시작점
            int tailStart = 0; // TAIL의 시작점
            answer[i][3] = String.valueOf(i);
            answer[i][4] = s; // 맨 마지막열에는 기존 파일명 저장

            for(int j=0;j<s.length();j++){
                if(s.charAt(j) >= '0' && s.charAt(j) <= '9') { // 처음나오는 숫자위치만 저장
                    numberStart = j;
                    answer[i][0] = s.substring(0, j);
                    break;
                }
            }

            for(int k=numberStart+1;k<s.length();k++){
                if(!(s.charAt(k)>='0' && s.charAt(k)<='9')){ // 숫자가 아닌 문자가 다시 시작되는 위치 tailStart에 저장
                    tailStart = k;
                    break;
                }
            }

            if(tailStart == 0){ // 숫자로만 끝나는 경우
                if(s.length() - numberStart <= 5){ // 숫자가 5자리 이내인 경우
                    String temp = s.substring(numberStart, s.length());
                    for(int k=0;k<temp.length();k++){
                        if(temp.charAt(k) != '0'){
                            answer[i][1] = temp.substring(k, temp.length()); // 정수 부분에 대해 0이 아닌 수로 시작하는 거 찾기
                            break;
                        }
                    }
                    answer[i][2] = "";
                }
                else { // 숫자가 5자리 초과인 경우
                    // answer[i][1] = 
                    String temp = s.substring(numberStart, numberStart+5);
                    for(int k=0;k<temp.length();k++){
                        if(temp.charAt(k) != '0'){
                            answer[i][1] = temp.substring(k, k+5); // 정수 부분에 대해 0이 아닌 수로 시작하는 거 찾기
                            break;
                        }
                    }
                    answer[i][2] = s.substring(numberStart+5, s.length());
                }

            }
            else { // 문자가 다시 한번 나오는 경우
                if(tailStart - numberStart > 5){ // 숫자가 다섯자리 초과한 경우
                    String temp = s.substring(numberStart, numberStart+5); // 정수 부분

                    for(int k=0;k<temp.length();k++){
                        if(temp.charAt(k) != '0'){
                            answer[i][1] = temp.substring(k, k+5); // 정수 부분에 대해 0이 아닌 수로 시작하는 거 찾기
                            break;
                        }
                    }
                    answer[i][2] = s.substring(numberStart+5, s.length());
                }
                else { // 숫자가 다섯자리 이내인 경우
                    String temp = s.substring(numberStart, tailStart);
                    for(int k=0;k<temp.length();k++){
                        if(temp.charAt(k) != '0'){
                            answer[i][1] = temp.substring(k, tailStart); // 정수 부분에 대해 0이 아닌 수로 시작하는 거 찾기
                            break;
                        }
                    }
                    answer[i][2] = s.substring(tailStart, s.length());
                }
            }
            System.out.println(answer[i][0]+" "+answer[i][1]+" "+answer[i][2]);
        }
        // HEAD를 기준으로 사전 순 정렬
        Arrays.sort(answer, (o1, o2) -> {
            if(o1[0].compareToIgnoreCase(o2[0]) == 0){ // 동일한 경우
                if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])){ // 숫자가 같은 경우
                    return Integer.parseInt(o1[3])-Integer.parseInt(o2[3]); // 입력받은 순서 유지
                }
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
            return o1[0].compareToIgnoreCase(o2[0]);
        });

        for(int i=0;i<files.length;i++){
            result[i] = answer[i][4];
        }
        return result;
    }
}
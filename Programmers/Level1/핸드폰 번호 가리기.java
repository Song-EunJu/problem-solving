class Solution {
    public String solution(String phone_number) {
        int length = phone_number.length();

        // string을 char형 배열로 바꾸기 replaceAll()?
        char [] answer = phone_number.toCharArray();

        for(int i=0;i<length-4;i++){
            answer[i] = '*';
        }
        String answer2 = new String(answer);
        return answer2;
    }
}
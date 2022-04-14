/*
    4177252841 을 예로 들면 number.length()-k = 10-4 = 6자리의 수를 리턴해야 함
    뒤에 5자리 수를 남겨두고 41772에서 큰 수 정하기 -> 7 (인덱스 2)
    인덱스 2부터 시작하여 뒤에 4자리 수를 남겨두고 725에서 큰 수 정하기 -> 7 (인덱스 3)
    인덱스 3부터 시작하여 뒤에 3자리 수를 남겨두고 252에서 큰 수 정하기 -> 5 (인덱스 5)
    인덱스 5부터 시작하여 뒤에 2자리 수를 남겨두고 28에서 큰 수 정하기 -> 8 (인덱스 7)
    인덱스 7부터 시작하여 뒤에 1자리 수를 남겨두고 4에서 큰 수 정하기 -> 4 (인덱스 8)
    인덱스 8부터 시작하여 뒤에 0자리 수를 남겨두고 1에서 큰 수 정하기 -> 1
*/
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx=0, j;
        for(int i=0;i<number.length()-k;i++){
            int max=0;
            for(j=idx;j<=k+i;j++){
                if(max < number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    idx=j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
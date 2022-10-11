class Solution {
    public int[] solution(String s) {
        int zero=0;
        int cnt=0;
        int sum=0;
        while(s.length()!=1){

            // 문자열에서 0 개수를 세고
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0')
                    zero++;
            }

            // 현재 문자열에서 0 개수를 다 뺀 만큼의 수를 2진수로 만든다
            int num = s.length()-zero;
            s = Integer.toBinaryString(num);
            cnt++; // 이진 변환의 횟수
            sum+=zero; // 매 변환과정마다 제거되는 0의 갯수의 합계
            zero = 0;
        }
        return new int[]{cnt, sum};
    }
}

class Solution {
    public int[] solution(String s) {
        int zero=0;
        int count=0;
        while(s.length()!=1){
            int orgCount = s.length();
            s = s.replaceAll("0",""); // 0을 모두 공백으로 변환
            zero+=(orgCount-s.length()); // 원래 문자열 길이 - 0을 제외한 문자열의 길이 = 제거된 0의 개수
            s = Integer.toBinaryString(s.length()); // 문자열의 길이 숫자 자체를 이진수 문자열로 변환
            count++;
        }
        return new int[]{count, zero};
    }
}
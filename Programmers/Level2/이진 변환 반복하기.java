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
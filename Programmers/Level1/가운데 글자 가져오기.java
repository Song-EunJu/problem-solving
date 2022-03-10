class Solution {
    public String solution(String s) {
        // String answer = "";
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        if(len%2==0){
            sb.append(s.charAt(len/2-1));
            sb.append(s.charAt(len/2));
        }
        else{
            sb.append(s.charAt(len/2));
        }
        return sb.toString();
    }
}
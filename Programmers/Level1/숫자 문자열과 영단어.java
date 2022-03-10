class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){ // 숫자인 경우 그대로 넣기
                sb.append(ch);
            }
            else if(ch=='z'){ // zero
                sb.append("0");
                i+=3;
            }
            else if(ch=='o'){ // one
                sb.append("1");
                i+=2;
            }
            else if(ch=='t'){ // two, three
                if(s.charAt(i+1)=='w'){
                    sb.append("2");
                    i+=2;
                }
                else{
                    sb.append("3");
                    i+=4;
                }
            }
            else if(ch=='f'){ // four, five
                if(s.charAt(i+1)=='o'){
                    sb.append("4");
                    i+=3;
                }
                else{
                    sb.append("5");
                    i+=3;
                }
            }
            else if(ch=='s'){ // six, seven
                if(s.charAt(i+1)=='i'){
                    sb.append("6");
                    i+=2;
                }
                else{
                    sb.append("7");
                    i+=4;
                }
            }
            else if(ch=='e'){ // eight
                sb.append("8");
                i+=4;
            }
            else if(ch=='n'){ // nine
                sb.append("9");
                i+=3;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
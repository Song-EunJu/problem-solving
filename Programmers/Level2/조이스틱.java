class Solution {
    public int solution(String name) {
        int sum=0;
        int min = name.length()-1;
        for(int i=0;i<name.length();i++){
            sum+=Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);  // 상하로 굴리기

            int index = i+1;
            while(index<name.length() && name.charAt(index)=='A')
                index++;
            /*
                - 오른쪽으로 왔다가 다시 왼쪽으로 돌아가는 경우
                오른쪽으로 왔다가 온 만큼 되돌아가야 하므로 : i*2
                맨오른쪽부터 접근해야 하는 숫자 : name.length()-index
            */
            min = Math.min(min, i*2+name.length()-index);

            /*
                - 왼쪽으로 갔다가 오른쪽으로 가는 경우
                왼쪽으로 갔다가 온 만큼 다시 오른쪽으로 돌아가야 하므로 : (name.length()-index)*2
                왼쪽부터 접근해야 하는 숫자 : i
            */
            min = Math.min(min, (name.length()-index)*2+i);
        }
        sum+=min;
        return sum;
    }
}

class Solution {
    public int solution(String name) {
        int sum=0;
        int min = name.length()-1; // 좌우로 움직이는 가장 짧은 경우는 그냥 오른쪽으로 1칸씩 끝까지 가는 방법
        for(int i=0;i<name.length();i++){
            char ch = name.charAt(i);
            sum+=Math.min(ch-'A', 'Z'-ch+1);  // 상하로 굴리기

            /**
             * 모든 문자마다, i=현재위치. index=현재위치 이후에 A가 아닌 문자가 나오는 첫 위치 (다음에 방문할 index 위치) 구함
             * 
             * 목표 : 현재 위치에서 다음에 방문할 index 위치까지 움직이는 거리 계산하기
             * 배열의 0번 인덱스 지점부터 현위치까지 왔다가 다시 왼쪽으로 돌아가서 index 위치까지 가는 길이 빠른지
             * 배열의 0번 인덱스 지점에서 왼쪽으로 가서 index 위치에 먼저 갔다가 현위치로 오는게 빠른지
             * 
             * 이 연산을 모든 문자마다 하면서, 전체 문자열에서 좌우 이동거리가 가장짧은 구간을 구함
             */
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


// class Solution {
//     public int solution(String name) {
//         int i=0;
//         int sum=0;
//         while(true){
//             int j=0;
//             if(name.charAt(i)!='A')
//                 sum+=Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
//             if(i>=name.length()-1)
//                 break;
//             for(j=i+1;j<name.length();j++){
//                 if(name.charAt(j)!='A')
//                     break;
//             }
//             // 왼, 오른쪽 중 어디로 가는게 더 빠른지 더하기
//             sum+=Math.min(j-i, name.length()-j);
//             // A가 아닌 알파벳 인덱스로 넘어가기
//             i+=(j-i);
//         }
//         return sum;
//     }
// }


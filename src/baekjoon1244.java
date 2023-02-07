import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1244 {
    static int switchNum;
    static int switches[];
    public static void main(String[] args) throws IOException {
        /*
         *
         * 학생 몇명을 뽑아서 1이상이고 스위치개수 이하인 자연수를 나눠줌
         * 자신의 성별, 받은 수에 따라 스위치 조작
         * 남-> 스위치 번호가 자기가 받은 자연수의 배수이면 상태 변경
         * 여 -> 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로
         *            좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서,
         *            그 구간에 속한 스위치의 상태를 모두 바꾼다
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switchNum = Integer.parseInt(br.readLine());
        switches = new int[switchNum+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=switchNum;i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for(int i=0;i<studentNum;i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int receivedNum = Integer.parseInt(st.nextToken());
            changeSwitch(gender, receivedNum);
        }
        for(int j=1;j<=switchNum;j++) {
            System.out.print(switches[j]+" ");
            if(j%20==0)
                System.out.println();
        }
    }

    public static void changeSwitch(int gender, int receivedNum) {
        if(gender == 1) { // 스위치 번호가 자기가 받은 자연수의 배수이면 상태 변경
            for(int i=1;i<=switchNum;i++) {
                if(i%receivedNum == 0)
                    switches[i] = switches[i] == 0 ? 1 : 0;
            }
        } else { // 여자인 경우
            int left = receivedNum-1;
            int right = receivedNum+1;
            while(inDistance(left, right) && switches[left]==switches[right]) {
                left--;
                right++;
            }
            for(int i=left+1;i<right;i++) {
                switches[i] = switches[i] == 0 ? 1 : 0;
            }
        }
    }

    // 배열의 인덱스를 벗어나지 않게 하기 위해 인덱스 체크
    public static boolean inDistance(int left, int right) {
        if(left>=1 && right<=switchNum)
            return true;
        return false;
    }
}
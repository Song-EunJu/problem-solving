class Solution {
    static int zero=0, one=0;
    public int[] solution(int[][] arr) {
        int num = arr.length;
        check(arr, num, 0, 0);
        int[] answer = {zero, one};
        return answer;
    }

    void check(int[][] arr, int size, int n1, int n2){
        cal(arr,size, n1, n2);
        cal(arr,size, n1, n2+size);
        cal(arr,size, n1+size, n2);
        cal(arr,size, n1+size, n2+size);
    }

    void cal(int [][] arr, int size, int n1, int n2){
        if(n1>=arr.length || n2>=arr[0].length) // 배열을 벗어나지 않는 경우에만
            return;

        int zeroTmp=0;
        int oneTmp=0;

        for(int i=n1;i<n1+size;i++){
            for(int j=n2;j<n2+size;j++){
                if(arr[i][j]==1)
                    oneTmp++;
                else
                    zeroTmp++;
                if(oneTmp>0 && zeroTmp>0) // 모두 같은 수가 아닌 경우
                    break;
            }
        }
        if(zeroTmp!=0 && oneTmp==0) {// 모두 0인경우
            zero++;
        }
        else if(zeroTmp==0 && oneTmp != 0){// 모두 1인경우
            one++;
        }
        else
            check(arr, size/2, n1, n2);
    }
}

/* 함수 1개로 줄인 코드
class Solution {
    static int zero=0, one=0;

    void press(int [][] arr, int size, int n1, int n2){
        int sum=0;
        for(int i=n1;i<n1+size;i++){
            for(int j=n2;j<n2+size;j++){
                sum+=arr[i][j];
            }
        }

        if(sum==0) zero++;
        else if(sum==size*size) one++;
        else {
            int num = size/2;
            press(arr, num, n1, n2);
            press(arr, num, n1, n2+num);
            press(arr, num, n1+num, n2);
            press(arr, num, n1+num, n2+num);
        }
    }

    public int[] solution(int[][] arr) {
        press(arr, arr.length, 0, 0);
        return new int[] {zero, one};
    }
}
*/
import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        // 배열에 값 채우기
        int arr[][] = new int[rows+1][columns+1];
        int n = 1;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                arr[i][j] = n++;
            }
        }

        for(int i=0;i<queries.length;i++){
            LinkedList<Integer> list = new LinkedList<Integer>();

            int minY = queries[i][0];
            int minX = queries[i][1];
            int maxY = queries[i][2];
            int maxX = queries[i][3];

            int height = maxY-minY+1;
            int width = maxX-minX+1;
            int border = height*width - (height-2)*(width-2);// 테두리 개수

            int y = minY;
            int x = minX;
            while(border>0){
                if(y==minY && x<maxX) // 처음시작
                    list.add(arr[y][x++]);
                else if(y<maxY && x==maxX) // 2.4 지점에서 아래로 방향 변경
                    list.add(arr[y++][x]);
                else if(y==maxY && x>minX) // 5.4 지점에서 왼쪽으로 방향 변경
                    list.add(arr[y][x--]);
                else // 4.4 지점에서 위로 방향 변경
                    list.add(arr[y--][x]);
                border--;
            }
            answer[i] = Collections.min(list); // 최솟값 담기

            // 리스트의 맨 앞 값을 빼고 뒤에 넣기
            int first = list.pollLast();
            list.addFirst(first);

            // 배열을 다시 순회하면서 리스트에 담은 값 채워 넣기
            border = height*width - (height-2)*(width-2);
            y = minY;
            x = minX;
            int j=0;
            while(border>0){
                if(y==minY && x<maxX) // 처음시작
                    arr[y][x++] = list.get(j);
                else if(y<maxY && x==maxX) //2.4 변경
                    arr[y++][x] = list.get(j);
                else if(y==maxY && x>minX) // 5.4변경
                    arr[y][x--] = list.get(j);
                else
                    arr[y--][x] = list.get(j);
                border--;
                j++;
            }
        }
        return answer;
    }
}
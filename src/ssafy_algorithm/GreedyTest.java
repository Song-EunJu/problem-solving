package ssafy_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GreedyTest {
    private static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        /**
            보통 변수의 타입이 같으면 오버플로우나 언더 플로우가 발생하지 않지만 걱정이 된다면 아래처럼 작성해도 된다.
            return this.end != o.end ? Integer.compare(this.end, o.end) : Integer.compare(this.start, o.start);
        */
        @Override
        public int compareTo(Meeting o) {
            return (this.end == o.end) ? this.start - o.start : this.end - o.end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) {
        // 종료 시간 기준으로 정렬
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Meeting[] m = new Meeting[count];

        for(int i=0;i<count;i++){
            m[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(m);
        System.out.println(Arrays.toString(m));

        List<Meeting> result = new ArrayList<>();
        result.add(m[0]);

        for(int i=1;i<count;i++){
            // 마지막 회의 시간보다 현재 회의 시작시간이 같거나 크면 양립 가능
            if(result.get(result.size()-1).end <= m[i].start){
                result.add(m[i]);
            }
        }
        System.out.println(result.size());
        for(Meeting meeting : result)
            System.out.println(meeting);
    }
}

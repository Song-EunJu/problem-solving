import java.io.*;

public class baekjoon1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // n번째 수
        int cnt = 0;

        // 문자열로 처리
        int start = 666;
        String str = "";
        while (cnt != n) {
            str = Integer.toString(start);
            if (str.contains("666")) {
                cnt++;
            }
            start++;
        }
        bw.write(Integer.parseInt(str)+"\n");
        bw.flush();
    }
}

//import java.io.BufferedReader;
//        import java.io.InputStreamReader;
//        import java.io.IOException;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        int num = 666;
//        int count = 1;
//
//        while(count != N) {
//            num++;
//            if(String.valueOf(num).contains("666")) {
//                count++;
//            }
//
//            /*
//            String str = Integer.toString(start);
//            if (str.contains("666")) {
//                cnt++;
//            }*/
//        }
//        System.out.println(num);
//    }
//}

//import java.io.BufferedReader;
//        import java.io.InputStreamReader;
//public class Main {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int num = 666;
//        int cnt = 0;
//
//        for (int i = 666; cnt < N; i++) {
//            if (isAnswer(i)) {
//                cnt++;
//                if (cnt == N) {
//                    num = i;
//                }
//            }
//        }
//        System.out.println(num);
//    }
//    public static boolean isAnswer(int N) {
//        int a = N;
//        int b = N % 1000; // 666을 찾아야 하니까 1000으로 나눈 나머지
//
//        while (a > 665) {
//            if (b == 666) {
//                return true;
//            } else {
//                a /= 10;
//                b = a % 1000;
//            }
//        }
///*
//   예시 : 10359                    66663
//   1) a=10359, b=359               1) a=66663, b=0
//   2) a=1035, b=35                 2) b=6666, b=666
//   3) a=103, b=35
//*/
//        return false;
//    }
//}
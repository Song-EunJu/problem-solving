package ssafy;

import java.io.FileNotFoundException;

public class exception {
    public static void main(String[] args) {
        try {
            throw new FileNotFoundException();
        } catch(Exception e){
            e.printStackTrace();
        }

        // 다형성에 의해서 어차피 하위 예외의 stackTrace 가 호출될 텐데 왜 굳이 위에서부터 잡냐
        // Exception 으로 잡으면 되는 거 아닌가??
        // sout 으로 메시지 출력해주려고 그런거냐? 친절한 메시지 써주려고 굳이 예외를 나눠서 써줘야하는건가?

        System.out.println("hi");
    }
}

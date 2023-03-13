import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a%10==0)
                sb.append(10+"\n");
            else {
                int aTemp = a%10;
                if(aTemp==1 || aTemp==5 || aTemp==6)
                    sb.append(aTemp+"\n");
                else if(aTemp==2){
                    if(b%4==1)
                        sb.append(2+"\n");
                    else if(b%4==2)
                        sb.append(4+"\n");
                    else if(b%4==3)
                        sb.append(8+"\n");
                    else if(b%4==0)
                        sb.append(6+"\n");
                }
                else if(aTemp==3){
                    if(b%4==1)
                        sb.append(3+"\n");
                    else if(b%4==2)
                        sb.append(9+"\n");
                    else if(b%4==3)
                        sb.append(7+"\n");
                    else if(b%4==0)
                        sb.append(1+"\n");
                }
                else if(aTemp==7){
                    if(b%4==1)
                        sb.append(7+"\n");
                    else if(b%4==2)
                        sb.append(9+"\n");
                    else if(b%4==3)
                        sb.append(3+"\n");
                    else if(b%4==0)
                        sb.append(1+"\n");
                }
                else if(aTemp==8){
                    if(b%4==1)
                        sb.append(8+"\n");
                    else if(b%4==2)
                        sb.append(4+"\n");
                    else if(b%4==3)
                        sb.append(2+"\n");
                    else if(b%4==0)
                        sb.append(6+"\n");
                }
                else if(aTemp==4){
                    if(b%2==1)
                        sb.append(4+"\n");
                    else if(b%2==0)
                        sb.append(6+"\n");
                }
                else if(aTemp==9){
                    if(b%2==1)
                        sb.append(9+"\n");
                    else if(b%2==0)
                        sb.append(1+"\n");
                }
            }
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}

/*
a^b%10
3 -> 3%10
3^2 = 9 -> 9
3^3 = 27 -> 7


*/
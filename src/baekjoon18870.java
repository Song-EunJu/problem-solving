import java.io.*;
import java.util.*;

public class baekjoon18870 {
    public static void main(String[] args) throws IOException {
        String tempObject = "{\"frame1\":\"C:\\\\Users\\\\Windows10\\\\GaoriCropImages\\\\20.png\",\"frame10\":\"C:\\\\Users\\\\Windows10\\\\GaoriCropImages\\\\23.png\",\"frame2\":\"C:\\\\Users\\\\Windows10\\\\GaoriCropImages\\\\5.png\",\"frame3\":\"C:\\\\Users\\\\Windows10\\\\GaoriCropImages\\\\18.png\",\"frame4\":\"C:\\\\Users\\\\Windows10\\\\GaoriCropImages\\\\21.png\",\"frame5\":\"C:\\\\Users\\\\Windows10\\\\GaoriCropImages\\\\8.png\",\"frame6\":\"C:\\\\Users\\\\Windows10\\\\GaoriCropImages\\\\13.png\",\"frame7\":\"C:\\\\Users\\\\Windows10\\\\GaoriCropImages\\\\17.png\",\"frame8\":\"C:\\\\Users\\\\Windows10\\\\GaoriCropImages\\\\19.png\",\"frame9\":\"C:\\\\Users\\\\Windows10\\\\GaoriCropImages\\\\22.png\"}\n";
        System.out.println("========br======\n" + tempObject);
        StringBuilder strBuf = new StringBuilder(tempObject);
//        System.out.println("strBuf.toString() = " + strBuf.toString());
        strBuf.insert(0, '"');
        strBuf.insert(strBuf.length()-1, '"');
        System.out.println(strBuf.toString());


        for (int k = 0; k < strBuf.toString().length(); k++) {
            if (k == 0 || k==strBuf.toString().length()-2)
                continue;
//            System.out.println("strBuf.charAt(k) = " + strBuf.charAt(k));
            if (strBuf.charAt(k) == '"') {
                strBuf.insert(k, "\\");
                k++;
            }
            if (strBuf.charAt(k) == '\\'){
                if(strBuf.charAt(k+1) == '\\'){
                    strBuf.insert(k, "\\\\");
                    k+=2;
                }
            }
        }
        System.out.println(strBuf.toString());

    }
}

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        Map<Integer, Integer> map = new HashMap<>();
//
//        int num = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int arr[]= new int[num];
//
//        for(int i=0;i<num;i++){
//            arr[i]=Integer.parseInt(st.nextToken());
//        }
//
//        int copy[] = arr.clone();
//        Arrays.sort(copy);
//
//        int cnt=0;
//        for(int i=0;i<num;i++)
//            if(!map.containsKey(copy[i]))
//                map.put(copy[i], cnt++);
//
//        for(int i=0;i<num;i++)
//            sb.append(map.get(arr[i])+" ");
//
//        System.out.println(sb);


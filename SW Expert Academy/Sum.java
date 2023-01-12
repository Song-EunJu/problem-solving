public class tt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<10;i++) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[100][100];

            for(int j=0;j<100;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0;k<100;k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int rowMax = Integer.MIN_VALUE;
            int colMax = Integer.MIN_VALUE;

            // 행과 열의 최대
            for(int j=0;j<100;j++){
                int rowSum = 0;
                int colSum = 0;
                for(int k=0;k<100;k++){
                    rowSum += arr[j][k];
                    colSum += arr[k][j];
                }
                rowMax = Math.max(rowMax, rowSum);
                colMax = Math.max(colMax, colSum);
            }

            // 대각선의 최대
            int diagSum = 0;
            for(int j=0;j<100;j++){
                diagSum += arr[j][j];
            }

            System.out.println("#"+n+" "+Math.max(Math.max(rowMax, colMax), diagSum));
        }
    }
}

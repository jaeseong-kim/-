import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        // 초기화
        int[][] arr = new int[31][31];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][0] = 1;
                arr[i][i] = 1;
                arr[i][1] = i;
            }
        }
        
        // 경우의 수 구하기
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        // 질의
        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(arr[M][N]).append("\n");

            T--;
        }
        
        // 출력
        bw.write(sb.toString());
        bw.close();
    }
}
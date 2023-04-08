import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int[][] dp = new int[2][41];

        // 초기화
        dp[0][0] = 1;
        dp[1][0] = 0;
        dp[0][1] = 0;
        dp[1][1] = 1;

        // dp 구하기
        for (int i = 2; i < 41; i++) {
            dp[0][i] = dp[0][i - 2] + dp[0][i - 1];
            dp[1][i] = dp[1][i - 2] + dp[1][i - 1];
        }
        
        // N 입력
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {

            int N = Integer.parseInt(br.readLine());

            sb.append(dp[0][N]).append(" ").append(dp[1][N]).append("\n");

            T--;
        }

        // 출력
        bw.write(sb.toString());
        bw.close();
    }
}
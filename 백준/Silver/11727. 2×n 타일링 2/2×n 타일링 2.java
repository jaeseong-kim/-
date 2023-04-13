import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] sum = new int[N + 1];

        // 초기화
        dp[1] = 1;
        sum[0] = 0;

        // dp[N] 구하기
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                dp[i] = (sum[i - 1] + 2) % MOD;
            } else {
                dp[i] = (sum[i - 1] + 1) % MOD;
            }

            sum[i] = sum[i - 1] + dp[i];
        }
        
        // 출력
        System.out.println(dp[N]);
    }
}
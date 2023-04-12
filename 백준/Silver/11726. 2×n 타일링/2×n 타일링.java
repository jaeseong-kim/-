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

        // dp[N] 구하기
        dp(N, dp);

        System.out.println(dp[N]);

    }

    public static void dp(int n, int[] dp) {
        if (n == 1) {
            dp[1] = 1;
            return;
        }

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
    }
}
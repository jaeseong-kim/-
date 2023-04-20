import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        for (int i = 1; i < dp[1].length; i++) {
            dp[1][i] = 1;
        }

        if (N > 1) {
            for (int i = 2; i <= N; i++) {

                dp[i][0] = dp[i - 1][1];
                dp[i][9] = dp[i - 1][8];
                for (int j = 1; j < dp[i].length - 1; j++) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < dp[N].length; i++) {
            sum = (sum + dp[N][i]) % MOD;
        }

        System.out.println(sum);
    }
}
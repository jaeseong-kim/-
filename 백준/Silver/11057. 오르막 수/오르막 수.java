import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력
        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[N + 1][11];
        long[] dp = new long[N + 1];

        // N 자리 수의 오르막 수 구하기
        long sum = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i][1] = 1;
            for (int j = 2; j < arr[i].length; j++) {
                arr[i][j] = (arr[i][j - 1] + arr[i - 1][j]) % MOD;
                sum += arr[i][j];
                sum %= MOD;
            }
            dp[i] = sum;
            sum = 1;
        }

        // 출력
        long answer = dp[N];
        System.out.println(answer);
    }
}
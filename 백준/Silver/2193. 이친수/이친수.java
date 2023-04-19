import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];



        // answer 구하기
        long answer;
        if (N == 1) {
            answer = 1;
        } else if (N == 2) {
            answer = 1;
        } else {

            dp[1] = 1;
            dp[2] = 1;

            for (int i = 3; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            answer = dp[N];
        }

        // 출력
        System.out.println(answer);
    }
}
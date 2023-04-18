import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        // arr 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp 초기화
        dp[1] = arr[1];

        // 최대값 구하기
        for (int i = 2; i < dp.length; i++) {

            int max = -1;
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    max = Math.max(max, arr[j]);
                } else {
                    max = Math.max(max, arr[j] + dp[i - j]);
                }
            }

            dp[i] = max;
        }

        // 출력
        System.out.println(dp[N]);

    }
}
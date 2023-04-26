import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];

        // arr 입력
        for (int i = 1; i < arr.length; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(nums[j - 1]);
            }
        }

        // dp 1행 초기화
        for (int i = 1; i < dp[1].length; i++) {
            dp[1][i] = arr[1][i];
        }

        // dp 구하기
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }

                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + arr[i][j];

                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }

        // 출력
        System.out.println(max * max);
    }
}
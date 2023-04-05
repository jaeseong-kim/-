import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사이즈 입력
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];
        
        // arr 초기화
        StringTokenizer st;
        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 1;
            while (st.hasMoreTokens()) {
                arr[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 초기화
        for (int i = 1; i < arr[N].length; i++) {
            dp[N][i] = arr[N][i];
        }

        // 최대값 구하기
        for (int i = arr.length - 2; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(arr[i][j] + dp[i + 1][j], arr[i][j] + dp[i + 1][j + 1]);
            }
        }

        // 출력
        System.out.println(dp[1][1]);
    }
}
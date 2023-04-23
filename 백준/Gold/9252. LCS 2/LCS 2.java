import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char[] row;
    public static char[] col;
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        row = br.readLine().toCharArray();
        col = br.readLine().toCharArray();

        // dp 구하기
        int[][] dp = new int[row.length + 1][col.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (row[i - 1] == col[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // lcs 길이
        int lcs = dp[row.length][col.length];

        // lcs 문자열 구하기
        sb = new StringBuffer();
        getLcs(dp, row.length, col.length);

        // 출력
        if (lcs == 0) {
            System.out.println(lcs);
        } else {
            System.out.println(lcs);
            System.out.println(sb.reverse().toString());

        }
    }

    public static void getLcs(int[][] dp, int r, int c) {
        if (r < 1 || c < 1) {
            return;
        }

        if (row[r - 1] == col[c - 1]) {
            sb.append(row[r - 1]);
            getLcs(dp, r - 1, c - 1);
        } else {
            if (dp[r][c - 1] > dp[r - 1][c]) {
                getLcs(dp, r, c - 1);
            } else {
                getLcs(dp, r - 1, c);
            }
        }
    }
}
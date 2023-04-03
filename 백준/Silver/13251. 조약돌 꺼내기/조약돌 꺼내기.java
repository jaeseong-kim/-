import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 조약돌 종류 입력
        int[] colors = new int[N];
        double[] percent = new double[N];
        for (int i = 0; i < percent.length; i++) {
            percent[i] = 1.0;
        }

        // 색깔별 조약돌 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sumColor = 0;
        for (int i = 0; i < colors.length; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            sumColor += colors[i];
        }

        // 색깔별 뽑는 경우의 수 구하기
        int k = Integer.parseInt(br.readLine());
        double answer = 0.0;
        for (int i = 0; i < colors.length; i++) {
            if (k <= colors[i]) {
                int n = colors[i];
                int m = sumColor;
                for (int j = 0; j < k; j++) {
                    percent[i] *= (double) (n - j) / (m - j);
                }
                answer += percent[i];
            }
        }

        // 출력
        System.out.println(answer);
    }

    public static int countCases(int m, int n) {
        int[][] arr = new int[m + 1][m + 1];

        // 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;
            arr[i][1] = i;
            arr[i][i] = 1;
        }

        // 경우의 수
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        return arr[m][n];
    }
}
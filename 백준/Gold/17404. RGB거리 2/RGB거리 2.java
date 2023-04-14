import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][4];
        int[][] sumNoRed = new int[N + 1][4];
        int[][] sumNoGreen = new int[N + 1][4];
        int[][] sumNoBlue = new int[N + 1][4];

        // 비용 입력
        StringTokenizer st;
        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        // 초기화
        for (int i = 1; i <= 3; i++) {
            if (i == 1) {
                sumNoRed[1][i] = INF;
                sumNoGreen[1][i] = arr[1][i];
                sumNoBlue[1][i] = arr[1][i];
            } else if (i == 2) {
                sumNoRed[1][i] = arr[1][i];
                sumNoGreen[1][i] = INF;
                sumNoBlue[1][i] = arr[1][i];
            } else {
                sumNoRed[1][i] = arr[1][i];
                sumNoGreen[1][i] = arr[1][i];
                sumNoBlue[1][i] = INF;
            }
        }

        // sum 구하기
        for (int i = 2; i <= N; i++) {
            sumNoRed[i][1] = arr[i][1] + Math.min(sumNoRed[i - 1][2], sumNoRed[i - 1][3]);
            sumNoRed[i][2] = arr[i][2] + Math.min(sumNoRed[i - 1][1], sumNoRed[i - 1][3]);
            sumNoRed[i][3] = arr[i][3] + Math.min(sumNoRed[i - 1][1], sumNoRed[i - 1][2]);

            sumNoGreen[i][1] = arr[i][1] + Math.min(sumNoGreen[i - 1][2], sumNoGreen[i - 1][3]);
            sumNoGreen[i][2] = arr[i][2] + Math.min(sumNoGreen[i - 1][1], sumNoGreen[i - 1][3]);
            sumNoGreen[i][3] = arr[i][3] + Math.min(sumNoGreen[i - 1][1], sumNoGreen[i - 1][2]);

            sumNoBlue[i][1] = arr[i][1] + Math.min(sumNoBlue[i - 1][2], sumNoBlue[i - 1][3]);
            sumNoBlue[i][2] = arr[i][2] + Math.min(sumNoBlue[i - 1][1], sumNoBlue[i - 1][3]);
            sumNoBlue[i][3] = arr[i][3] + Math.min(sumNoBlue[i - 1][1], sumNoBlue[i - 1][2]);
        }

        // 비교
        int answer = Math.min(Math.min(sumNoRed[N][1], sumNoGreen[N][2]), sumNoBlue[N][3]);

        // 출력
        System.out.println(answer);
    }
}
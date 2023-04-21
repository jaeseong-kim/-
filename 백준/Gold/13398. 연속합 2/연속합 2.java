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
        int[] L = new int[N + 1];
        int[] R = new int[N + 1];

        // 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽 연속 최대 합 배열 구하기
        int max = arr[1];
        L[1] = arr[1];
        for (int i = 2; i < L.length; i++) {
            L[i] = Math.max(arr[i], arr[i] + L[i - 1]);

            max = Math.max(max, L[i]);
        }

        // 오른쪽 연속 최대 합 배열 구하기
        R[N] = arr[N];
        for (int i = N - 1; i > 0; i--) {
            R[i] = Math.max(arr[i], arr[i] + R[i + 1]);
        }

        // i번째 수 뺀 최대 값과 비교
        int tmp;
        for (int i = 2; i < N; i++) {
            tmp = L[i - 1] + R[i + 1];
            max = Math.max(max, tmp);
        }

        // 출력
        System.out.println(max);
    }
}
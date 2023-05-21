import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr, answer;
    public static boolean[] visited;

    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        // 배열 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 수열 찾기
        sb = new StringBuffer();
        seq(0, 0, M);

        // 출력
        System.out.println(sb);
    }

    public static void seq(int idx, int cur, int depth) {
        if (cur == depth) {
            for (int i = 0; i < answer.length; i++) {
                sb.append(answer[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[cur] = arr[i];
                seq(i, cur + 1, depth);
                visited[i] = false;
            }
        }
    }
}
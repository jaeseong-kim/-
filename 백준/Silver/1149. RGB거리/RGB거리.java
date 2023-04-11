import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][N + 1];
        int[][] cost = new int[N + 1][N + 1];
        
        // 비용 입력
        StringTokenizer st;
        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        // cost 초기화
        cost[1][1] = arr[1][1];
        cost[1][2] = arr[1][2];
        cost[1][3] = arr[1][3];

        // cost 구하기
        for (int i = 2; i <= N; i++) {
            cost[i][1] = arr[i][1] + Math.min(cost[i - 1][2], cost[i - 1][3]);
            cost[i][2] = arr[i][2] + Math.min(cost[i - 1][1], cost[i - 1][3]);
            cost[i][3] = arr[i][3] + Math.min(cost[i - 1][1], cost[i - 1][2]);
        }

        // 출력
        System.out.println(Math.min(Math.min(cost[N][1], cost[N][2]), cost[N][3]));

    }
}
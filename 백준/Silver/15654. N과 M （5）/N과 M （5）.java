import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static boolean[] visited;

    private static int[] answer;
    private static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 배열 입력
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        sb = new StringBuffer();
        answer = new int[M];
        Arrays.sort(arr);
        
        // M개 뽑기
        function(0, M);
        
        // 출력
        System.out.println(sb);
    }

    private static void function(int cur, int depth) {
        if (cur == depth) {
            for (int i = 0; i < answer.length; i++) {
                sb.append(answer[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[cur] = arr[i];
                function(cur + 1, depth);
                visited[i] = false;
            }
        }
    }
}
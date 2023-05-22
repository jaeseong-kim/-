import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr, prev, answer;
    public static boolean[] visited;

    public static List<int[]> list;
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        visited = new boolean[N];
        prev = new int[M];
        answer = new int[M];
        
        // 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(arr);

        list = new ArrayList<>();
        sb = new StringBuffer();
        seq(0, M);
        
        // 출력
        System.out.println(sb);

    }

    public static void seq(int cur, int depth) {
        if (cur == depth) {

            if (!cotains(answer)) {
                list.add(answer.clone());

                for (int i = 0; i < answer.length; i++) {
                    sb.append(answer[i]).append(" ");
                }

                sb.append("\n");
            }
            
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[cur] = arr[i];
                seq(cur + 1, depth);
                visited[i] = false;
            }
        }
    }

    public static boolean cotains(int[] arr1) {

        for (int[] tmp : list) {
            if (Arrays.equals(arr1, tmp)) {
                return true;
            }
        }

        return false;
    }
}
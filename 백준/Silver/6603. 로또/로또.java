import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static Integer[] arr;
    public static boolean[] visited;
    public static int PICK_NUMS = 6;
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");

            int K = Integer.parseInt(st.nextToken());

            if (K == 0) {
                break;
            }

            arr = new Integer[K];
            visited = new boolean[K];

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb = new StringBuffer();
            dfs(0, 0);

            System.out.println();
        }
    }

    public static void dfs(int cur, int depth) {

        if (depth == 6) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = cur; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

}
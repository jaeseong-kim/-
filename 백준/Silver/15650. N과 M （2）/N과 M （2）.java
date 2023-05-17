import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static Integer[] arr;
    public static boolean[] visited;

    public static ArrayList<Integer> list;
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 자연수 배열
        arr = new Integer[N];
        visited = new boolean[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // 백트래킹
        list = new ArrayList();
        sb = new StringBuffer();
        combination(0, 0, M);

        // 출력
        System.out.println(sb);
    }

    public static void combination(int idx, int cur, int depth) {
        if (cur == depth) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                combination(i, cur + 1, depth);
                list.remove(arr[i]);
                visited[i] = false;
            }
        }
    }
}
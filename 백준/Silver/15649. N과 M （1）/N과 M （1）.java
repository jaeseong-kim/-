import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static Integer[] arr;
    public static boolean[] visited;

    public static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 자연수 배열 입력
        arr = new Integer[N];
        visited = new boolean[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // 백트래킹
        list = new ArrayList<>();
        combination(0, M);

    }

    public static void combination(int cur, int depth) {
        if (cur == depth) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }

            System.out.println(sb);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                combination(cur + 1, depth);
                list.remove(arr[i]);
                visited[i] = false;
            }
        }
    }
}
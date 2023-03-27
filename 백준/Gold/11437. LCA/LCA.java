import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static LinkedList<Integer>[] list;
    public static int[] depth;
    public static int[] parents;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        list = new LinkedList[N + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new LinkedList();
        }

        // 트리만들기
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        depth = new int[N + 1];
        parents = new int[N + 1];
        visited = new boolean[N + 1];

        // 깊이, 부모 구하기
        dfs(1, 0);

        // LCA 구하기
        StringBuffer sb = new StringBuffer();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getLcs(a, b)).append("\n");
        }

        // 출력
        bw.write(sb.toString() + "\n");
        bw.close();
    }

    public static void dfs(int cur, int dep) {

        visited[cur] = true;
        depth[cur] = dep;

        for (int i = 0; i < list[cur].size(); i++) {
            int n = list[cur].get(i);

            if (!visited[n]) {
                parents[n] = cur;
                dfs(n, dep + 1);
            }
        }
    }

    public static int getLcs(int a, int b) {

        //두 노드의 깊이를 맞추기, 더 깊은 노드가 위로 올라 와야 함.
        if (depth[a] > depth[b]) {
            int gap = depth[a] - depth[b];

            for (int i = 0; i < gap; i++) {
                a = parents[a];
            }
        } else {
            int gap = depth[b] - depth[a];

            for (int i = 0; i < gap; i++) {
                b = parents[b];
            }
        }

        //두 노드의 값이 같아질 때까지 반복
        while (a != b) {

            a = parents[a];
            b = parents[b];
        }

        return a;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        //노드 생성
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[N + 1];

        //간선 만들기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        //오름차순 정렬
        for (int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        //DFS와 BFS
        sb = new StringBuffer();
        DFS(graph, visited, start);
        System.out.println(sb);


        sb = new StringBuffer();
        visited = new boolean[N + 1];
        BFS(graph, visited, start);
        System.out.println(sb);

    }

    public static void DFS(List<Integer>[] graph, boolean[] visited, int v) {

        sb.append(v).append(" ");
        visited[v] = true;

        for (int i = 0; i < graph[v].size(); i++) {
            int node = graph[v].get(i);
            if (!visited[node]) {
                DFS(graph, visited, node);
            }
        }
    }

    public static void BFS(List<Integer>[] graph, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();

        //초기화
        queue.add(v);
        visited[v] = true;

        //시작
        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            sb.append(curNode).append(" ");

            for (int i = 0; i < graph[curNode].size(); i++) {
                int newNode = graph[curNode].get(i);
                if (!visited[newNode]) {
                    visited[newNode] = true;
                    queue.add(newNode);
                }
            }
        }
    }
}
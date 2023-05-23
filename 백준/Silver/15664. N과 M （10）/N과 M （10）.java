import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int DEPTH;

    public static int[] arr, answer, prev;
    public static boolean[] visited;
    public static StringBuffer sb;

    public static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        DEPTH = Integer.parseInt(st.nextToken());


        arr = new int[N];
        visited = new boolean[N];
        answer = new int[DEPTH];
        prev = new int[DEPTH];

        // 배열 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 수열 구하기
        list = new ArrayList<>();
        sb = new StringBuffer();
        seq(0, 0);

        // 출력
        System.out.println(sb);
    }

    public static void seq(int idx, int curDepth) {
        if (curDepth == DEPTH) {
            if (!contains(answer)) {
                list.add(answer.clone());
                for (int i = 0; i < answer.length; i++) {
                    sb.append(answer[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[curDepth] = arr[i];
                seq(i, curDepth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean contains(int[] arr) {
        for (int i = 0; i < list.size(); i++) {
            if (Arrays.equals(list.get(i), arr)) {
                return true;
            }
        }

        return false;
    }
}
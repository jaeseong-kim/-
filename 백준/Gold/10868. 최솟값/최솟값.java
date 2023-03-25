import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int INF = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N <= 2^k를 만족하는 2^k 구하기
        int leftIdx = 1;
        while (leftIdx < N) {
            leftIdx *= 2;
        }

        // 세그먼트 트리 만들기 초기화
        int size = leftIdx * 2;
        int[] tree = new int[size];

        Arrays.fill(tree, INF);

        // 최소값 세그먼트 트리 만들기
        for (int i = leftIdx; i < leftIdx + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        for (int i = leftIdx - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }

        // (a, b)쌍 입력받기
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int startIdx = Integer.parseInt(st.nextToken()) + leftIdx - 1;
            int endIdx = Integer.parseInt(st.nextToken()) + leftIdx - 1;

            sb.append(getMin(tree, startIdx, endIdx)).append("\n");

        }

        // 출력
        bw.write(sb.toString());
        bw.close();
    }

    public static int getMin(int[] tree, int startIdx, int endIdx) {

        int result = Integer.MAX_VALUE;

        while (startIdx <= endIdx) {
            if (startIdx % 2 == 1) {
                result = Math.min(result, tree[startIdx]);
            }

            if (endIdx % 2 == 0) {
                result = Math.min(result, tree[endIdx]);
            }

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }

        return result;
    }
}
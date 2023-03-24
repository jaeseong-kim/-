import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int changeNum = Integer.parseInt(st.nextToken());
        int sumNum = Integer.parseInt(st.nextToken());

        // 세그먼트 트리 사이즈 구하기
        int k = 0;
        int size = 0;
        while (true) {
            if (size >= N) {
                size = size * 2;
                break;
            }
            size = (int) Math.pow(2, ++k);
        }
        long[] arr = new long[size];

        // 세그먼트 트리 초기화
        int idx = (int) Math.pow(2, k);
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());

            arr[idx++] = num;
        }

        for (int i = (int) Math.pow(2, k) - 1; i > 0; i--) {
            arr[i] = arr[2 * i] + arr[2 * i + 1];
        }

        // 숫자 바꾸기, 구간합 구하기
        for (int i = changeNum + sumNum; i > 0; i--) {
            st = new StringTokenizer(br.readLine(), " ");

            long a = Long.parseLong(st.nextToken());


            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                ;
                update(arr, b, c, k);
                changeNum--;
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(sum(arr, b, c, k)).append("\n");
                sumNum--;
            }
        }

        //출력
        System.out.println(sb.toString());
    }

    public static void update(long[] arr, int idx, long n, int k) {
        int index = (int) Math.pow(2, k) + idx - 1;

        long gap = n - arr[index];
        arr[index] = n;

        index = index / 2;
        while (index > 0) {
            arr[index] += gap;
            index /= 2;
        }
    }

    public static long sum(long[] arr, int from, int to, int k) {
        int startIdx = from + (int) Math.pow(2, k) - 1;
        int endIdx = to + (int) Math.pow(2, k) - 1;

        long answer = 0;
        while (startIdx <= endIdx) {

            if (startIdx % 2 == 1) {
                answer += arr[startIdx];
            }
            if (endIdx % 2 == 0) {
                answer += arr[endIdx];
            }

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }

        return answer;
    }
}
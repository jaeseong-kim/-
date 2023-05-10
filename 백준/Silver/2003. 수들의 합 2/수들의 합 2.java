import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터
        int cnt = 0;
        int sum = arr[0];
        int startIdx = 0;
        int endIdx = 0;
        while (endIdx != N) {

            if (sum > M) {
                sum = sum - arr[startIdx];
                startIdx++;
            } else if (sum < M) {
                endIdx++;
                if (arr.length <= endIdx) {
                    break;
                }
                sum = sum + arr[endIdx];
            } else {
                cnt++;
                endIdx++;
                if (arr.length <= endIdx) {
                    break;
                }
                sum = sum + arr[endIdx];
            }
        }

        System.out.println(cnt);
    }
}
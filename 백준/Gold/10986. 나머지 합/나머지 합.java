import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long[] sumArr = new long[N];
        long[] remainder = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        sumArr[0] = arr[0];
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }


        for (int i = 0; i < sumArr.length; i++) {
            sumArr[i] %= M;

            if (sumArr[i] == 0) {
                answer++;
            }
        }

        for (int i = 0; i < sumArr.length; i++) {
            int idx = (int) sumArr[i];
            remainder[idx]++;
        }

        for (int i = 0; i < remainder.length; i++) {
            if (remainder[i] > 1) {
                answer = answer + (remainder[i] * (remainder[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
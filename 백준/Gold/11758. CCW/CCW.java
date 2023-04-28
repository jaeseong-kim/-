import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[4][3];

        for (int i = 1; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int ccw = getCcw(arr);

        System.out.println(ccw);
    }

    public static int getCcw(int[][] arr) {
        int ccw = (arr[1][1] * arr[2][2] + arr[2][1] * arr[3][2] + arr[3][1] * arr[1][2])
                - (arr[2][1] * arr[1][2] + arr[3][1] * arr[2][2] + arr[1][1] * arr[3][2]);


        if (ccw < 0) {
            return -1;
        } else if (ccw == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
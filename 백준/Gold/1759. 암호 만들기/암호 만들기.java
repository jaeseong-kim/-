import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static char[] arr, answer;
    public static boolean[] visited;
    public static int DEPTH;
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // DEPTH, C 입력
        DEPTH = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        answer = new char[DEPTH];
        visited = new boolean[C];

        // 알파벳 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 암호 구하기
        sb = new StringBuffer();
        getPassword(0, 0);

        // 출력
        System.out.println(sb);
    }

    public static void getPassword(int idx, int cur) {
        if (cur == DEPTH) {
            if (checkPassword(answer)) {
                for (int i = 0; i < answer.length; i++) {
                    sb.append(answer[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[cur] = arr[i];
                getPassword(i, cur + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean checkPassword(char[] answer) {
        int moeum = 0;
        int jaeum = 0;

        for (int i = 0; i < answer.length; i++) {
            char c = answer[i];

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                moeum = moeum + 1;
                continue;
            }
            jaeum = jaeum + 1;
        }

        if (moeum < 1 || jaeum < 2) {
            return false;
        }
        return true;
    }
}
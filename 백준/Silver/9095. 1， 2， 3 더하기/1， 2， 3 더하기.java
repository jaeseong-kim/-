import java.io.*;

public class Main {
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        answer = 0;

        // 경우의 수 구하기
        while (T > 0) {

            int N = Integer.parseInt(br.readLine());

            dfs(N);
            
            sb.append(answer).append("\n");

            answer = 0;
            T--;
        }

        // 출력
        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int n) {
        if (n < 0) {
            return;
        }

        if (n == 0) {
            answer++;
            return;
        }

        for (int i = 1; i < 4; i++) {
            dfs(n - i);
        }
    }
}
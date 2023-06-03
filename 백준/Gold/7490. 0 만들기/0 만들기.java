import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static StringBuffer sb;
    public static char[] arr;
    public static char[] operators;
    public static int DEPTH;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        operators = new char[]{' ', '+', '-'};

        while (T > 0) {

            // N 입력
            int N = Integer.parseInt(br.readLine());

            // 자연수 배열 입력
            arr = new char[N + N - 1];
            char num = '1';
            for (int i = 0; i < arr.length; i += 2) {
                arr[i] = num;
                num += 1;
            }

            // 0 되는 경우의 수 구하기
            sb = new StringBuffer();
            DEPTH = arr.length - 1;
            recursion(1);

            // 출력
            System.out.println(sb);

            T--;
        }
    }

    public static void recursion(int curIdx) {
        if (curIdx > DEPTH) {
            StringBuffer tmp = new StringBuffer();
            tmp.append(arr);

            // 공백 처리
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == ' ') {
                    tmp.replace(i, i + 1, "");
                }
            }

            // +, - 계산
            StringTokenizer st = new StringTokenizer(tmp.toString(), "+-", true);
            int answer = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                String o = st.nextToken();

                switch (o) {
                    case "+":
                        answer = answer + Integer.parseInt(st.nextToken());
                        break;
                    case "-":
                        answer = answer - Integer.parseInt(st.nextToken());
                        break;
                }
            }

            if (answer == 0) {
                sb.append(arr).append("\n");
            }
            return;
        }

        for (int i = 0; i < operators.length; i++) {
            arr[curIdx] = operators[i];
            recursion(curIdx + 2);
        }
    }
}
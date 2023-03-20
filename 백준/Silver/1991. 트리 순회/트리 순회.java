import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];

        // 2차원 배열로 트리 만들기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String alphabet = st.nextToken();
            int index = alphabet.charAt(0) - 'A';

            String left = st.nextToken();
            String right = st.nextToken();

            arr[index][0] = left;
            arr[index][1] = right;
        }

        // 전위, 중위, 후위 순회
        sb = new StringBuffer();
        preOrder(arr, "A");
        sb.append("\n");
        inOrder(arr, "A");
        sb.append("\n");
        postOrder(arr, "A");

        // 출력
        bw.write(sb.toString());
        bw.close();
    }

    public static void preOrder(String[][] arr, String cur) {

        int index = cur.charAt(0) - 'A';

        sb.append(cur);

        // 왼쪽
        if (!arr[index][0].equals(".")) {
            preOrder(arr, arr[index][0]);
        }

        // 오른쪽
        if (!arr[index][1].equals(".")) {
            preOrder(arr, arr[index][1]);
        }
    }

    public static void inOrder(String[][] arr, String cur) {

        int index = cur.charAt(0) - 'A';

        // 왼쪽
        if (!arr[index][0].equals(".")) {
            inOrder(arr, arr[index][0]);
        }

        sb.append(cur);

        // 오른쪽
        if (!arr[index][1].equals(".")) {
            inOrder(arr, arr[index][1]);
        }
    }

    public static void postOrder(String[][] arr, String cur) {
        
        int index = cur.charAt(0) - 'A';

        // 왼쪽
        if (!arr[index][0].equals(".")) {
            postOrder(arr, arr[index][0]);
        }

        // 오른쪽
        if (!arr[index][1].equals(".")) {
            postOrder(arr, arr[index][1]);
        }

        sb.append(cur);
    }
}
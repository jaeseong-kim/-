import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr, answer;
    public static int DEPTH;
    public static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        
        int N = Integer.parseInt(st.nextToken());
        DEPTH = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[DEPTH];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        set = new LinkedHashSet<>();
        seq(0, 0);

        for (String s : set) {
            bw.write(s + "\n");
        }

        bw.close();
    }

    public static void seq(int idx, int cur) {
        if (cur == DEPTH) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < answer.length; i++) {
                sb.append(answer[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            answer[cur] = arr[i];
            seq(i, cur + 1);
        }
    }
}
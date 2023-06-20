import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 단어 입력
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.length() < M) {
                continue;
            }

            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        // map을 array로
        String[] arr = new String[map.size()];
        int idx = 0;
        for (String s : map.keySet()) {
            arr[idx++] = s;
        }

        // 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int numO1 = map.get(o1);
                int numO2 = map.get(o2);

                if (numO1 == numO2) {
                    if (o1.length() == o2.length()) {
                        String shortStr = (o1.length() > o2.length()) ? o2 : o1;
                        for (int i = 0; i < shortStr.length(); i++) {
                            char c1 = o1.charAt(i);
                            char c2 = o2.charAt(i);

                            if (c1 != c2) {
                                return c1 - c2;
                            }
                        }
                    }
                    return o2.length() - o1.length();
                }

                return numO2 - numO1;
            }
        });

        // 출력
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
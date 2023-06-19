import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] file = br.readLine().split("\\.");
            String extension = file[1];

            if (map.containsKey(extension)) {
                map.replace(extension, map.get(extension) + 1);
            } else {
                map.put(extension, 1);
            }
        }

        String[] arr = new String[map.size()];
        int i = 0;
        for (String s : map.keySet()) {
            arr[i++] = s;
        }

        Arrays.sort(arr);

        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < arr.length; j++) {
            sb.append(arr[j]).append(" ").append(map.get(arr[j])).append("\n");
        }

        System.out.println(sb);
    }
}
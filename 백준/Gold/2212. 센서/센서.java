import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 센서, 집중국 개수 입력
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        // 센서 입력
        int[] sensors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < sensors.length; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(sensors);

        // 센서 거리 차이 배열
        Integer[] dist = new Integer[sensors.length - 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = sensors[i + 1] - sensors[i];
        }

        // 내림차순 정렬
        Arrays.sort(dist, Collections.reverseOrder());

        // 최소합 구하기
        int min = 0;
        for (int i = K - 1; i < dist.length; i++) {
            min += dist[i];
        }

        // 출력
        System.out.println(min);
    }
}
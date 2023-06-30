import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N, L 입력
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // arr 입력
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);
        
        /*
         최소 테이프의 개수 구하기
            1. stop이 물이 새는 곳보다 크다면 이미 봉합했다는 의미
            2. (물이 새는 곳 - stop) > 0.5 stop 위치 갱신
            3. 나머지는 stop에 테이프를 붙임
         */
        
        int answer = 0;
        double stop = arr[0] - 0.5;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < stop) {
                continue;
            } else if (arr[i] - stop > 0.5) {
                stop = arr[i] - 0.5 + L;
                answer += 1;
            } else {
                stop = stop + L;
                answer += 1;
            }

        }

        // 출력
        System.out.println(answer);
    }
}
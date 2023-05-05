import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 배열
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(arr);

        // 최대값 구하기
        int max = -1;
        int tmp;
        for(int i = 0; i < arr.length; i++){
            tmp = arr[i]*(arr.length - i);

            if(max < tmp){
                max = tmp;
            }
        }

        // 출력
        System.out.println(max);

    }
}
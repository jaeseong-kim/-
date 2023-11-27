import java.io.*;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] sum = new int[N];
        int M = Integer.parseInt(br.readLine());
        
        // 배열 입력, 배열 합 구하기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i == 0) {
                sum[i] = arr[i];
            } else {
                sum[i] = arr[i] + sum[i - 1];
            }
        }

        // 구간 합 출력
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 1){
                bw.write(sum[b-1]+"\n");
            }else{
                bw.write(sum[b-1] - sum[a - 2]+"\n");
            }

        }

        bw.close();
    }
}
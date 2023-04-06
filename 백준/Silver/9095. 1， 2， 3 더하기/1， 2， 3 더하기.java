import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int[] dp = new int[11];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        // 경우의 수 구하기
       while(T > 0){
           int N = Integer.parseInt(br.readLine());
           
           if(N>3){
               for(int i = 4; i <= N; i++){
                   dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
               }
           }
           
           sb.append(dp[N]).append("\n");
           T--;
       }

        // 출력
        bw.write(sb.toString());
        bw.close();
    }
}
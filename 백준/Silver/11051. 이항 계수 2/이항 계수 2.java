import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = 1;
            arr[i][1] = i;
            arr[i][i] = 1;
        }

        for(int i = 2; i < arr.length; i++){
            for(int j = 1; j<i; j++){
                arr[i][j] = (arr[i-1][j-1]+arr[i-1][j])%10007;
            }
        }

        System.out.println(arr[n][k]);
    }
}
import java.io.*;
import java.util.*;

public class Main{
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 입력
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < arr.length; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        
        // 정렬
        Arrays.sort(arr);
        
        // 누적합
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(sum + 1 < arr[i]){
                break;
            }
            sum += arr[i];
        }
        
        int answer = sum + 1;
        
        System.out.println(answer);
    }
}
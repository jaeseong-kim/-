import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Set<Integer> set = new HashSet();
       
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }
        
        int[] arr = new int[set.size()];
        int idx = 0;
        for(int n : set){
            arr[idx++] = n;
        }
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}
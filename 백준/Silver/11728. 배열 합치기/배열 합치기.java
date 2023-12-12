import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arrN = new int[N];
        int[] arrM = new int[M];
        int[] arr = new int[N+M];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            
            arrN[i] = num;
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            
            arrM[i] = num;
        }
        
        // two pointer
        int indexN = 0;
        int indexM = 0;
        int index = 0;
        while(indexN < arrN.length && indexM < arrM.length){
            if(arrN[indexN] > arrM[indexM]){
                arr[index++] = arrM[indexM++]; 
            }else{
                arr[index++] = arrN[indexN++];
            }
        }
        
        while(indexN < arrN.length){
            arr[index++] = arrN[indexN++];
        }
        
        while(indexM < arrM.length){
            arr[index++] = arrM[indexM++];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}
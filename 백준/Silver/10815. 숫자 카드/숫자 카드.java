import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] sanggeun = new int[N];
        
        // 상근이 카드 입력
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < sanggeun.length; i++){
            sanggeun[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        int[] cards = new int[M];
        
        // 확인해야할 카드 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < cards.length; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        
        // 정렬
        Arrays.sort(sanggeun);
        
        // 이진 탐색
        int[] answer = new int[M];
        for(int i = 0; i < cards.length; i++){
            if(binarySearch(sanggeun, cards[i], 0, sanggeun.length - 1)){
                answer[i] = 1;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < answer.length; i++){
            sb.append(answer[i]).append(" ");
        }
        
        System.out.println(sb);
    }
    
    public static boolean binarySearch(int[] arr, int target, int left, int right){
        if(left > right){
            return false;
        }
        
        int mid = (left+right) / 2;
        
        if(target == arr[mid]){
            return true;
        }else if(target < arr[mid]){
            return binarySearch(arr, target, left, mid - 1);
        }else{
            return binarySearch(arr, target, mid + 1, right);
        }
    }
}
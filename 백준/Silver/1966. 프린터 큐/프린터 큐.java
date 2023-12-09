import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            LinkedList<int[]> queue = new LinkedList();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }
            
            int count = 0;
            
            while(!queue.isEmpty()){
                // [원래 순서, 중요도]
                int[] front = queue.poll();
                boolean isMax = true;
                
                for(int i = 0; i < queue.size(); i++){
                    if(front[1] >= queue.get(i)[1]){
                        continue;
                    }
                    
                    queue.add(front);
                    for(int j = 0; j < i; j++){
                        queue.add(queue.poll());
                    }
                    
                    
                    isMax = false;
                    break;
                }
                
                if(!isMax){
                    continue;
                }
                
                count++;
                if(front[0] == M){
                    break;
                }
            }
            
            System.out.println(count);
            
        }
        
    }
}
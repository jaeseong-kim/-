import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            
            // 초기화
            int length = commands[i][1] - commands[i][0] + 1;
            int[] subArr = new int[length];
            int idx = 0;
            
            // 복사
            for(int j = commands[i][0] - 1; j < commands[i][1]; j++){
                subArr[idx++] = array[j];
            }
            
            // 정렬
            Arrays.sort(subArr);
            
            // k번째 수
            answer[i] = subArr[commands[i][2] - 1];
        }
        
        return answer;
    }
}
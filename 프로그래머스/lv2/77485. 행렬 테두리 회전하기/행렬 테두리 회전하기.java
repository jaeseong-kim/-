class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows+1][columns+1];
        
        // arr[rows][columns] 만들기
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[i].length; j++){
                arr[i][j] = ((i-1)*columns+j);
            }
        }
        
        // queries 개수 반복
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            
            // 시계방향으로 회전
            rotate(arr, query);
            
            // 최소값 구하기
            int min = Integer.MAX_VALUE;
            
            // →
            for(int j = query[1]; j <= query[3]; j++){
                min = Math.min(min,arr[query[0]][j]);
            }
            
            // ↓
            for(int j = query[0]; j <= query[2]; j++){
                min = Math.min(min,arr[j][query[3]]);
            }
            
            // ←
            for(int j = query[3]; j >= query[1]; j--){
                min = Math.min(min,arr[query[2]][j]);
            }
            
            // ↑
            for(int j = query[2]; j > query[0]; j--){
                min = Math.min(min, arr[j][query[1]]);
            }
            
            answer[i] = min;
            
        }
        
        return answer;
    }
    
    public void rotate(int[][] arr,int[] query){
        int firstNum = arr[query[0]][query[1]];
        
        // ↑
        for(int i = query[0]; i < query[2]; i++){
            arr[i][query[1]] = arr[i+1][query[1]];
        }
        
        // ←
        for(int i = query[1]; i < query[3]; i++){
            arr[query[2]][i] = arr[query[2]][i+1];
        }
        
        // ↓
        for(int i = query[2]; i > query[0]; i--){
            arr[i][query[3]] = arr[i-1][query[3]];
        }
        
        // →
        for(int i = query[3]; i > query[1]+1; i--){
            arr[query[0]][i] = arr[query[0]][i-1];
        }
        
        arr[query[0]][query[1]+1] = firstNum;
    }
}
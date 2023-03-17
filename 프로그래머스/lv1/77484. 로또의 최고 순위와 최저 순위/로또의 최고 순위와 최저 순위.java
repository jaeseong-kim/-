class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int winCnt = 0;
        int zeroCnt = 0;
        for(int i = 0; i<lottos.length; i++){
            if(lottos[i]==0){
                zeroCnt++;
                continue;
            }
            
            for(int j = 0; j<win_nums.length; j++){
                if(lottos[i]==win_nums[j]){
                    winCnt++;
                    break;
                }
            }
        }
        
        answer[0] = checkPrize(winCnt+zeroCnt);
        answer[1] = checkPrize(winCnt);
        
        
        return answer;
    }
    
    public int checkPrize(int winNums){
        int rank;
        
        switch(winNums){
            case 6:
                rank=1;
                break;
            case 5:
                rank=2;
                break;
            case 4:
                rank=3;
                break;
            case 3:
                rank=4;
                break;
            case 2:
                rank=5;
                break;
            default:
                rank=6;
        }
        
        return rank;
    }
}
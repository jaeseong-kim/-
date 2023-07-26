import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] days = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
                days[i] = (int)Math.ceil((100-progresses[i])/(double)speeds[i]);
        }
        
        for(int i = 0; i < days.length;i++){
            System.out.print(days[i]+" ");
        }
        
        List<Integer> list = new LinkedList<>();
        int curDay = days[0];
        int release = 0;
        for(int i = 0; i < days.length; i++){
            if(days[i] <= curDay){
                release+=1;
                continue;
            }
            list.add(release);
            curDay = days[i];
            release = 1;
        }
        
        list.add(release);
        
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
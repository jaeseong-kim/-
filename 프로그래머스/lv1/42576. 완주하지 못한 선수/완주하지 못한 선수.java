import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // participant = 참가자, completion = 완주자
        // 참가자를 map에 삽입
        // 완주자를 map에서 하나씩 제거
        // map에 남은 사람은 미완주자
        
        Map<String,Integer> map = new HashMap();
        for(int i = 0; i < participant.length; i++){
            
            String participantMan = participant[i];
            
            if(map.containsKey(participantMan)){
                map.replace(participantMan,map.get(participantMan)+1);
            }else{
                map.put(participantMan,1);
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < completion.length; i++){
            
            String completeMan = completion[i];
            
            if(map.containsKey(completeMan)){
                
                map.replace(completeMan,map.get(completeMan)-1);
            
                if(map.get(completeMan)==0){
                    map.remove(completeMan,map.get(completeMan));
                }
            }
        }
        
        for(String unCompleteMan : map.keySet()){
            sb.append(unCompleteMan);
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}
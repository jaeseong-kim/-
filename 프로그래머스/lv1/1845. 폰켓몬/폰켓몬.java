import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int num = nums.length/2;
        Set<Integer> set = new HashSet();
        
        for(int i : nums){
            if(!set.contains(i)){
                set.add(i);
            }
        }
        
        answer = num < set.size() ? num : set.size();
        
        return answer;
    }
}